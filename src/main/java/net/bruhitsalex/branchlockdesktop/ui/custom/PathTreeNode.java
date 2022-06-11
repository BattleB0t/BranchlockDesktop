package net.bruhitsalex.branchlockdesktop.ui.custom;

import lombok.Getter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

@Getter
public class PathTreeNode extends DefaultMutableTreeNode {

    public static final String PREFIX = "./";

    private final File parentDirectory;

    public PathTreeNode(File parentDirectory) {
        this.parentDirectory = parentDirectory;
        setUserObject(PREFIX + parentDirectory.getName());
    }

}
