package net.bruhitsalex.branchlockdesktop.saved;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import net.bruhitsalex.branchlockdesktop.ui.settings.LogPane;

import javax.swing.*;
import java.io.File;
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
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            appSettings = mapper.readValue(appSettingsFile, AppSettings.class);
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
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            mapper.writeValue(appSettingsFile, appSettings);
        } catch (IOException e) {
            showIOIssue(appSettingsFile, e);
        }
    }

    private static void showIOIssue(File file, Exception e) {
        JOptionPane.showConfirmDialog(null, "Unable to create file '" + file.getAbsolutePath() + "'\n\n" + e.getMessage());
        System.exit(0);
    }

}
