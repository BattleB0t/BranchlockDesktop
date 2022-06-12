package net.bruhitsalex.branchlockdesktop.ui.processing;

import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.ui.impl.SwingFileIO;

import javax.swing.*;
import java.awt.*;

@Getter
public class JarIOPane extends JPanel {

    private final SwingFileIO input;
    private final SwingFileIO output;

    public JarIOPane() {
        input = new SwingFileIO("Input Jar");
        output = new SwingFileIO("Output Jar");
        setMaximumSize(new Dimension(Short.MAX_VALUE, 28));
        initLayout();
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
