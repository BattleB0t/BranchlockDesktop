package net.bruhitsalex.branchlockdesktop.ui.processing;

import lombok.Getter;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
public class LibrariesPane extends JPanel {

    private final List<File> files = new ArrayList<>();

    private final JLabel label;
    private final JTree tree;
    private final JButton add;
    private final JButton remove;

    public LibrariesPane() {
        label = new JLabel("Libraries");
        add = new JButton("Add");
        remove = new JButton("Remove");
        tree = new JTree();
        initLayout();
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(label)
                        .addGap(20, 20, 20)
                        .addComponent(tree, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(add)
                                        .addComponent(remove)
                        )
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(label)
                        .addComponent(tree, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(add, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(20, 20, 20)
                                        .addComponent(remove, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );

        setLayout(layout);
    }

}
