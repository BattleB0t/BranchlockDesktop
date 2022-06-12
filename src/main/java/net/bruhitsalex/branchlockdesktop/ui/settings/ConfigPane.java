package net.bruhitsalex.branchlockdesktop.ui.settings;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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

        JLabel tasksLabel = new JLabel(" Tasks");
        tasksLabel.setFont(new Font(tasksLabel.getFont().getFontName(), Font.BOLD, 18));

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(tasksLabel)
                        .addGap(5, 5, 5)
                        .addComponent(tasksPane)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(tasksLabel)
                        .addComponent(tasksPane)
        );

        setLayout(layout);
    }

}
