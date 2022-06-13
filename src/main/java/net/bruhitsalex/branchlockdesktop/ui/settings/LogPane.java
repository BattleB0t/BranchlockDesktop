package net.bruhitsalex.branchlockdesktop.ui.settings;

import javax.swing.*;
import java.time.LocalTime;

public class LogPane extends JTextArea {

    private static LogPane INSTANCE;

    public LogPane() {
        INSTANCE = this;
        setEditable(false);
    }

    public static void createSpacerLines() {
        if (INSTANCE == null) {
            return;
        }

        INSTANCE.setText(INSTANCE.getText() + "\n\n\n\n");
    }

    public static void addLine(Type type, String text) {
        if (INSTANCE == null) {
            return;
        }

        LocalTime localTime = LocalTime.now();
        String prefix = "\n";
        if (INSTANCE.getText().isEmpty()) {
            prefix = "";
        }
        INSTANCE.setText(INSTANCE.getText() + prefix + "[" + localTime.toString() + "] [" + type.name() + "] " + text);
    }

    public enum Type {
        GUI,
        MISC,
        OBFUSCATION;
    }

}
