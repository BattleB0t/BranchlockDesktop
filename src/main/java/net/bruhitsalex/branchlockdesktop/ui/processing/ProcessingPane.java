package net.bruhitsalex.branchlockdesktop.ui.processing;

import net.bruhitsalex.branchlockdesktop.ui.custom.JSplitter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProcessingPane extends JPanel {

    private JarIOPane jarIOPane;
    private final JSplitter firstSplitter = new JSplitter(20);

    public ProcessingPane() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        initComponents();
        initLayout();
    }

    private void initComponents() {
        jarIOPane = new JarIOPane();
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(jarIOPane)
                        .addGap(20, 20, 20)
                        .addComponent(firstSplitter)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(jarIOPane)
                        .addComponent(firstSplitter)
        );

        setLayout(layout);
    }

}
