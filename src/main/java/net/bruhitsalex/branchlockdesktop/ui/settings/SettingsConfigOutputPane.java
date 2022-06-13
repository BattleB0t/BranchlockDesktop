package net.bruhitsalex.branchlockdesktop.ui.settings;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@Getter
public class SettingsConfigOutputPane extends JTabbedPane {

    private final GlobalPane globalPane;
    private final TasksPane tasksPane;
    private final ObfuscationRangesPane obfuscationRangesPane;
    private final LogPane logPane;
    private final ConfigPane configPane;

    public SettingsConfigOutputPane() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        globalPane = new GlobalPane();
        tasksPane = new TasksPane();
        obfuscationRangesPane = new ObfuscationRangesPane();
        logPane = new LogPane();
        configPane = new ConfigPane();
        initLayout();
    }

    private void initLayout() {
        JScrollPane tasksScroller = new JScrollPane(tasksPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add("Tasks", tasksScroller);

        JScrollPane globalScroller = new JScrollPane(globalPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add("Global Settings", globalScroller);

        add("Obfuscation Ranges", obfuscationRangesPane);

        JScrollPane logScroller = new JScrollPane(logPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add("Output Log", logScroller);

        add("Configurations", configPane);
    }

}
