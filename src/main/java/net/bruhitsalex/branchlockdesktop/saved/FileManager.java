package net.bruhitsalex.branchlockdesktop.saved;

import net.bruhitsalex.branchlockdesktop.ui.settings.LogPane;
import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static File mainFolder;
    private static File scriptsFolder;

    private static File appSettingsFile;

    public static void init() {
        LogPane.addLine(LogPane.Type.INIT, "Checking local settings");
        checkFolders();
        checkAppSettings();
    }

    private static void checkFolders() {
        mainFolder = new File(System.getProperty("user.home"), ".branchlock/");
        if (!mainFolder.exists()) {
            mainFolder.mkdirs();
            LogPane.addLine(LogPane.Type.INIT, "Created folder: " + mainFolder.getAbsolutePath());
        }
        scriptsFolder = new File(mainFolder, "scripts/");
        if (!scriptsFolder.exists()) {
            scriptsFolder.mkdirs();
            LogPane.addLine(LogPane.Type.INIT, "Created folder: " + scriptsFolder.getAbsolutePath());
        }
        ScriptsManager.init(scriptsFolder);
    }

    private static void checkAppSettings() {
        appSettingsFile = new File(mainFolder, "app-settings.yml");
        if (!appSettingsFile.exists()) {
            createAppSettings();
            LogPane.addLine(LogPane.Type.INIT, "Creating /app-settings.yml");
        }

        AppSettings appSettings = null;
        try {
            appSettings = new Yaml().load(new FileReader(appSettingsFile));
        } catch (IOException e) {
            showIOIssue(appSettingsFile, e);
        }

        if (appSettings == null) {
            createAppSettings();
            checkAppSettings();
            return;
        }

        Settings.appSettings = appSettings;
    }

    private static void createAppSettings() {
        try {
            appSettingsFile.createNewFile();
        } catch (IOException e) {
            showIOIssue(appSettingsFile, e);
        }

        AppSettings appSettings = new AppSettings();
        appSettings.setDarkMode(true);
        Yaml yaml = new Yaml();
        try {
            yaml.dump(appSettings, new FileWriter(appSettingsFile));
        } catch (IOException e) {
            showIOIssue(appSettingsFile, e);
        }
    }

    private static void showIOIssue(File file, Exception e) {
        JOptionPane.showConfirmDialog(null, "Unable to create file '" + file.getAbsolutePath() + "'\n\n" + e.getMessage());
        System.exit(0);
    }

}
