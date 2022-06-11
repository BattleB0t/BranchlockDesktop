package net.bruhitsalex.branchlockdesktop.ui.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

@Getter
@AllArgsConstructor
public class JarTreeNode extends DefaultMutableTreeNode {

    private File jar;

}
