package net.bruhitsalex.branchlockdesktop.ui.processing;

import net.bruhitsalex.branchlockdesktop.ui.custom.JSplitter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProcessingPane extends JPanel {

    private JarIOPane jarIOPane;
    private LibrariesPane librariesPane;
    private final JSplitter firstSplitter = new JSplitter(2);
    private final JSplitter secondSplitter = new JSplitter(2);
    private ActionPane actionPane;

    public ProcessingPane() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        initComponents();
        initLayout();
    }

    private void initComponents() {
        jarIOPane = new JarIOPane();
        librariesPane = new LibrariesPane();
        actionPane = new ActionPane();
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(jarIOPane)
                        .addGap(20, 20, 20)
                        .addComponent(firstSplitter)
                        .addGap(10, 10, 10)
                        .addGap(2, 2, 2)
                        .addGap(10, 10, 10)
                        .addComponent(librariesPane, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(secondSplitter)
                        .addGap(20, 20, 20)
                        .addComponent(actionPane, 80, GroupLayout.PREFERRED_SIZE, 100)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(jarIOPane)
                        .addComponent(firstSplitter)
                        .addComponent(librariesPane)
                        .addComponent(secondSplitter)
                        .addComponent(actionPane)
        );

        setLayout(layout);
    }

}
