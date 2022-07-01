package net.bruhitsalex.branchlockdesktop.saved;

import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.Config;
import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
            Yaml yaml = new Yaml();
            yaml.dump(config, new FileWriter(file));
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
            Yaml yaml = new Yaml();
            try {
                Config config = yaml.loadAs(new FileReader(file), Config.class);
                allConfigs.add(config);
            } catch (FileNotFoundException ignored) {}
        }
    }

}
