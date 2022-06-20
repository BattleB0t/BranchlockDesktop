package net.bruhitsalex.branchlockdesktop.ui.settings;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class LogPane extends JTextArea {

    private static final Queue<LineWrapper> queue = new LinkedList<>();
    private static LogPane INSTANCE;

    public LogPane() {
        INSTANCE = this;
        setEditable(false);

        while (!queue.isEmpty()) {
            LineWrapper lineWrapper = queue.poll();
            addLine(lineWrapper.getType(), lineWrapper.getText());
        }
    }

    public static void addLine(Type type, String text) {
        if (INSTANCE == null) {
            queue.add(new LineWrapper(type, text));
            return;
        }

        if (type == Type.SPACER) {
            INSTANCE.setText(INSTANCE.getText() + "\n\n\n\n");
            return;
        }

        LocalTime localTime = LocalTime.now();
        String prefix = "\n";
        if (INSTANCE.getText().isEmpty()) {
            prefix = "";
        }
        INSTANCE.setText(INSTANCE.getText() + prefix + "[" + localTime.toString() + "] [" + type.name() + "] " + text);
    }

    public static void createSpacerLines() {
        addLine(Type.SPACER, "");
    }

    public enum Type {
        GUI,
        MISC,
        OBFUSCATION,
        INIT,
        SPACER;
    }

    @AllArgsConstructor
    @Getter
    public static class LineWrapper {
        private final Type type;
        private final String text;
    }

}
