package net.bruhitsalex.branchlockdesktop.ui.settings;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@Getter
public class ConfigPane extends JTabbedPane {

    private final TasksPane tasksPane;

    public ConfigPane() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        tasksPane = new TasksPane();
        initLayout();
    }

    private void initLayout() {
        JScrollPane tasksScroller = new JScrollPane(tasksPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add("Tasks", tasksScroller);
    }

}
