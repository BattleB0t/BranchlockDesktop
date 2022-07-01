package net.bruhitsalex.branchlockdesktop.saved;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.Config;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScriptsManager {

    private static File scriptsFolder;
    @Getter private static List<Config> allConfigs;

    public static void init(File scriptsFolder) {
        ScriptsManager.scriptsFolder = scriptsFolder;
        ScriptsManager.allConfigs = new ArrayList<>();
        saveDefaultScript();
        loadScriptsFromFile();
    }

    private static void saveDefaultScript() {
        File defaultScript = new File(scriptsFolder, "default.yml");
        saveConfig(Processing.getConfig(), defaultScript);
    }

    public static void saveConfig(Config config, File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to create file: " + file.getAbsolutePath());
                System.exit(-1);
            }
        }

        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            mapper.writeValue(file, config);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to save script: " + file.getAbsolutePath());
            System.exit(-1);
        }
    }

    private static void loadScriptsFromFile() {
        File[] found = scriptsFolder.listFiles();

        if (found == null || found.length == 0) {
            return;
        }

        for (File file : found) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            try {
                Config config = mapper.readValue(file, Config.class);
                allConfigs.add(config);
            } catch (FileNotFoundException ignored) {} catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
