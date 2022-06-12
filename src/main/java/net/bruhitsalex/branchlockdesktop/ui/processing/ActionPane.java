package net.bruhitsalex.branchlockdesktop.ui.processing;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;

public class ActionPane extends JPanel {

    private final JButton processButton;
    private final JProgressBar progressBar;
    private final JTextArea statusTextArea;

    public ActionPane() {
        processButton = new JButton("Process"); // new FlatSVGIcon("com/formdev/flatlaf/demo/extras/svg/actions/execute.svg")
        processButton.setIcon(new FlatSVGIcon("images/execute.svg"));
        progressBar = new JProgressBar();
        progressBar.setSize(progressBar.getWidth(), processButton.getHeight());
        statusTextArea = new JTextArea("Waiting...");
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
                                        .addGap(20, 20, 20)
                                        .addComponent(progressBar)
                        )
        );

        setLayout(layout);
    }

}
