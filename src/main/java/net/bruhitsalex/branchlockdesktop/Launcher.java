package net.bruhitsalex.branchlockdesktop;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme;
import net.bruhitsalex.branchlockdesktop.saved.FileManager;
import net.bruhitsalex.branchlockdesktop.saved.Settings;
import net.bruhitsalex.branchlockdesktop.ui.MainWindow;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {
        initUILaf();
        FileManager.init();
        initAndOpenUI();
    }

    private static void initUILaf() {
        FlatMaterialDarkerContrastIJTheme.setup();
        FlatLaf.setUseNativeWindowDecorations(true);
        UIManager.put("TitlePane.showIcon", true);
        UIManager.put("TitlePane.menuBarEmbedded", true);
        UIManager.put("TitlePane.unifiedBackground", true);
        UIManager.put("Component.focusWidth", 0.5);
        UIManager.put("TextArea.arc", 999);
        UIManager.put("ScrollPane.arc", 999);
    }

    private static void initAndOpenUI() {
        if (!Settings.appSettings.isDarkMode()) {
            FlatIntelliJLaf.setup();
        }
        MainWindow window = new MainWindow();
        SwingUtilities.invokeLater(() -> window.setVisible(true));
    }

}
