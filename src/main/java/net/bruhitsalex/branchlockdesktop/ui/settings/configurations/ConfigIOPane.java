package net.bruhitsalex.branchlockdesktop.ui.settings.configurations;

import javax.swing.*;
import java.awt.*;

public class ConfigIOPane extends JPanel {

    private JLabel label;
    private JList<String> fileNames;

    public ConfigIOPane() {
        initComponents();
        initLayout();
    }

    private void initComponents() {
        label = new JLabel("Saved Configurations");
        label.setFont(label.getFont().deriveFont(Font.BOLD).deriveFont(16f));
        fileNames = new JList<>(new String[] {"default.yml", "cguard.yml"});
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(label)
                        .addGap(5, 5, 5)
                        .addComponent(fileNames)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(label)
                        .addComponent(fileNames)
        );

        setLayout(layout);
    }

}
