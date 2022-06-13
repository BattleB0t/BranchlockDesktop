package net.bruhitsalex.branchlockdesktop.ui.settings.obfranges;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.ui.utils.UIUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ObfuscationRangesTree extends JTree {

    public static ObfuscationRangesTree INSTANCE;

    private final DefaultMutableTreeNode root;
    private final DefaultMutableTreeNode exclusions;
    private final DefaultMutableTreeNode inclusions;

    public ObfuscationRangesTree() {
        super(new DefaultMutableTreeNode("Obfuscation ranges"));
        INSTANCE = this;
        root = (DefaultMutableTreeNode) getModel().getRoot();
        exclusions = new DefaultMutableTreeNode("Exclusions");
        inclusions = new DefaultMutableTreeNode("Inclusions");
        root.add(exclusions);
        root.add(inclusions);
        reloadTreeUI();
    }

    public void reloadTreeUI() {
        ((DefaultTreeModel) getModel()).reload(root);
        UIUtils.expandAllNodes(this);
    }

    public void setOptionFromConfig() {
        exclusions.removeAllChildren();
        Processing.getConfig().getObfuscationRanges().getExclusions().forEach(s -> {
            exclusions.add(new StringTreeNode(s));
        });
        inclusions.removeAllChildren();
        Processing.getConfig().getObfuscationRanges().getInclusions().forEach(s -> {
            inclusions.add(new StringTreeNode(s));
        });
        reloadTreeUI();
    }

}