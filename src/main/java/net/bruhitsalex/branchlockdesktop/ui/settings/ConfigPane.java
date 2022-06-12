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

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(tasksPane)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(tasksPane)
        );

        setLayout(layout);
    }

}
