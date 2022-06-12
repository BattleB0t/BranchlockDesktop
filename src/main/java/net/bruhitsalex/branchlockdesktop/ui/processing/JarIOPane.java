package net.bruhitsalex.branchlockdesktop.ui.processing;

import li.flor.nativejfilechooser.NativeJFileChooser;
import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.ui.impl.SwingFileIO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

@Getter
public class JarIOPane extends JPanel {

    public static JarIOPane INSTANCE;

    private final SwingFileIO input;
    private final SwingFileIO output;

    public JarIOPane() {
        INSTANCE = this;
        input = new SwingFileIO("Input Jar");
        output = new SwingFileIO("Output Jar");
        setMaximumSize(new Dimension(Short.MAX_VALUE, 28));
        initActions();
        initLayout();
    }

    private void initActions() {
        JFileChooser inputFileChooser = new NativeJFileChooser();
        inputFileChooser.setFileFilter(new FileNameExtensionFilter("JAR", "*.jar"));
        inputFileChooser.setMultiSelectionEnabled(false);
        input.getButton().addActionListener(e -> {
            int result = inputFileChooser.showDialog(this, "Pick Jar");
            if (result == JFileChooser.APPROVE_OPTION) {
                input.getPath().setText(inputFileChooser.getSelectedFile().getAbsolutePath());
            }
            ActionPane.INSTANCE.checkProcessValidity();
        });

        JFileChooser outputFileChooser = new NativeJFileChooser();
        outputFileChooser.setFileFilter(new FileNameExtensionFilter("JAR", "*.jar"));
        outputFileChooser.setMultiSelectionEnabled(false);
        outputFileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        output.getButton().addActionListener(e -> {
            int result = outputFileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                output.getPath().setText(outputFileChooser.getSelectedFile().getAbsolutePath());
            }
            ActionPane.INSTANCE.checkProcessValidity();
        });
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(input.getLabel())
                                        .addComponent(input.getPath())
                                        .addComponent(input.getButton())
                        )
                        .addGap(20, 20, 20)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(output.getLabel())
                                        .addComponent(output.getPath())
                                        .addComponent(output.getButton())
                        )
        );

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(input.getLabel())
                                        .addComponent(output.getLabel())
                        )
                        .addGap(10, 10, 10)
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(input.getPath())
                                        .addComponent(output.getPath())
                        )
                        .addGap(5, 5, 5)
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(input.getButton())
                                        .addComponent(output.getButton())
                        )
        );

        setLayout(layout);
    }

}
