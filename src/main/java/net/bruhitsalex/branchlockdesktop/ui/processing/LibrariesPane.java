package net.bruhitsalex.branchlockdesktop.ui.processing;

import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.ui.custom.JarTreeNode;
import net.bruhitsalex.branchlockdesktop.ui.custom.PathTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
public class LibrariesPane extends JPanel {

    private final DefaultMutableTreeNode root;
    private final JLabel label;
    private final JTree tree;
    private final JButton add;
    private final JButton remove;

    public LibrariesPane() {
        label = new JLabel("Libraries");
        add = new JButton("Add");
        remove = new JButton("Remove");
        tree = new JTree(root = new DefaultMutableTreeNode("0 libraries added"));
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

    public void addLibrary(File file) {
        File parent = file.getParentFile();
        String name = ".../" + parent.getName();

        DefaultMutableTreeNode newOrFoundChild = new PathTreeNode(parent);
        boolean wasFound = false;
        for (int i = 0; i < root.getChildCount(); i++) {
            PathTreeNode child = (PathTreeNode) root.getChildAt(i);
            if (name.equals(child.getUserObject())) {
                newOrFoundChild = child;
                wasFound = true;
                break;
            }
        }

        if (wasFound) {
            root.add(newOrFoundChild);
        }

        newOrFoundChild.add(new JarTreeNode(file));
    }

    public List<File> getAllLibraries() {
        List<File> files = new ArrayList<>();

        for (int i = 0; i < root.getChildCount(); i++) {
            PathTreeNode pathNode = (PathTreeNode) root.getChildAt(i);
            for (int n = 0; n < pathNode.getChildCount(); n++) {
                JarTreeNode jarTreeNode = (JarTreeNode) pathNode.getChildAt(n);
                files.add(jarTreeNode.getJar());
            }
        }

        return files;
    }

}
