package net.bruhitsalex.branchlockdesktop.ui.custom;

import lombok.Getter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

@Getter
public class JarTreeNode extends DefaultMutableTreeNode {

    private final File jar;

    public JarTreeNode(File jar) {
        this.jar = jar;
        setUserObject(jar.getName());
    }

}
