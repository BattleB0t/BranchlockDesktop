package net.bruhitsalex.branchlockdesktop.ui.processing;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

public class ActionPane extends JPanel {

    public static ActionPane INSTANCE;

    private final JButton processButton;
    private final JProgressBar progressBar;
    private final JTextArea statusTextArea;

    public ActionPane() {
        INSTANCE = this;
        processButton = new JButton("Process");
        processButton.setIcon(new FlatSVGIcon("images/execute.svg"));
        processButton.setEnabled(false);
        progressBar = new JProgressBar();
        progressBar.setMinimumSize(new Dimension(progressBar.getWidth(), 8));
        statusTextArea = new JTextArea("Waiting...");
        statusTextArea.setEditable(false);
        initLayout();
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(processButton)
                                        .addComponent(progressBar)
                        )
                        .addGap(10, 10, 10)
                        .addComponent(statusTextArea)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(statusTextArea)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(processButton)
                                        .addGap(10, 10, 10)
                                        .addComponent(progressBar)
                        )
        );

        setLayout(layout);
    }

    public void checkProcessValidity() {
        processButton.setEnabled(
                !JarIOPane.INSTANCE.getInput().getPath().getText().isEmpty()
                && !JarIOPane.INSTANCE.getOutput().getPath().getText().isEmpty()
        );
    }

}
