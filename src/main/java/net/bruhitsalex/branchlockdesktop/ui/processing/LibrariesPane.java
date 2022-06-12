package net.bruhitsalex.branchlockdesktop.ui.processing;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import li.flor.nativejfilechooser.NativeJFileChooser;
import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.ui.custom.JarTreeNode;
import net.bruhitsalex.branchlockdesktop.ui.custom.PathTreeNode;
import net.bruhitsalex.branchlockdesktop.ui.utils.UIUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
        add.setIcon(new FlatSVGIcon("images/add.svg"));
        remove = new JButton("Remove");
        remove.setIcon(new FlatSVGIcon("images/remove.svg"));
        remove.setEnabled(false);
        tree = new JTree(root = new DefaultMutableTreeNode("0 libraries added"));
        initActions();
        initLayout();
    }

    private void initActions() {
        JFileChooser libraryFileChooser = new NativeJFileChooser();
        libraryFileChooser.setFileFilter(new FileNameExtensionFilter("JAR", "*.jar"));
        libraryFileChooser.setMultiSelectionEnabled(true);
        add.addActionListener(e -> {
            int result = libraryFileChooser.showDialog(this, "Add Library");
            if (result == JFileChooser.APPROVE_OPTION) {
                for (File file : libraryFileChooser.getSelectedFiles()) {
                    addLibrary(file);
                }
            }
        });

        tree.addTreeSelectionListener(e -> remove.setEnabled(tree.getSelectionPaths() != null));

        remove.addActionListener(e -> {
            if (tree.getSelectionPaths() == null) {
                return;
            }

            for (TreePath treePath : tree.getSelectionPaths()) {
                removeLibrary(treePath);
            }

            reloadTreeUI();
        });
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        JScrollPane treeScroller = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(label)
                        .addGap(20, 20, 20)
                        .addComponent(treeScroller, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(treeScroller, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        String name = PathTreeNode.PREFIX + parent.getName();

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

        if (!wasFound) {
            root.add(newOrFoundChild);
        } else {
            for (int i = 0; i < newOrFoundChild.getChildCount(); i++) {
                JarTreeNode jarTreeNode = (JarTreeNode) newOrFoundChild.getChildAt(i);
                if (jarTreeNode.getJar().equals(file)) {
                    return;
                }
            }
        }

        newOrFoundChild.add(new JarTreeNode(file));

        reloadTreeUI();
    }

    private void removeLibrary(TreePath treePath) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
        if (defaultMutableTreeNode.isRoot()) {
            return;
        }

        if (defaultMutableTreeNode instanceof JarTreeNode) {
            JarTreeNode jarTreeNode = (JarTreeNode) defaultMutableTreeNode;
            PathTreeNode pathTreeNode = (PathTreeNode) jarTreeNode.getParent();
            pathTreeNode.remove(jarTreeNode);
            if (pathTreeNode.getChildCount() <= 0) {
                root.remove(pathTreeNode);
            }
        } else if (defaultMutableTreeNode instanceof PathTreeNode) {
            root.remove(defaultMutableTreeNode);
        }
    }

    private void reloadTreeUI() {
        root.setUserObject(getAllLibraries().size() + " libraries added");
        ((DefaultTreeModel) tree.getModel()).reload(root);
        UIUtils.expandAllNodes(tree);
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
