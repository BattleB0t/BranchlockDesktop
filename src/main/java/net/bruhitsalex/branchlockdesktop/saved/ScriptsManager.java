package net.bruhitsalex.branchlockdesktop.saved;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.Config;
import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;

public class ScriptsManager {

    private static File scriptsFolder;

    public static void init(File scriptsFolder) {
        ScriptsManager.scriptsFolder = scriptsFolder;
        saveDefaultScript();
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

}
