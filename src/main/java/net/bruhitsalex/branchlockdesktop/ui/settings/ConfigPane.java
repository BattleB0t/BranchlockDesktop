package net.bruhitsalex.branchlockdesktop.ui.settings;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@Getter
public class ConfigPane extends JPanel {

    private final TasksPane tasksPane;

    public ConfigPane() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        tasksPane = new TasksPane();
        initLayout();
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        JScrollPane tasksScroller = new JScrollPane(tasksPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(tasksScroller)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(tasksScroller)
        );

        setLayout(layout);
    }

}
