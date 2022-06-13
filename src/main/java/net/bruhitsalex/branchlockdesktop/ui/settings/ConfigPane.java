package net.bruhitsalex.branchlockdesktop.ui.settings;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@Getter
public class ConfigPane extends JTabbedPane {

    private final GlobalPane globalPane;
    private final TasksPane tasksPane;
    private final ObfuscationRangesPane obfuscationRangesPane;

    public ConfigPane() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        globalPane = new GlobalPane();
        tasksPane = new TasksPane();
        obfuscationRangesPane = new ObfuscationRangesPane();
        initLayout();
    }

    private void initLayout() {
        JScrollPane tasksScroller = new JScrollPane(tasksPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add("Tasks", tasksScroller);

        JScrollPane globalScroller = new JScrollPane(globalPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add("Global Settings", globalScroller);

        JScrollPane obfRangesScroller = new JScrollPane(obfuscationRangesPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add("Obfuscation Ranges", obfRangesScroller);
    }

}
