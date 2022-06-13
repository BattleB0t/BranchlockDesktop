package net.bruhitsalex.branchlockdesktop.ui.utils;

import javax.swing.*;
import java.awt.*;

public class UIUtils {

    public static void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2) - 50;
        frame.setLocation(x, y);
    }

    public static void expandAllNodes(JTree tree){
        expandAllNodes(tree, 0, tree.getRowCount());
    }

    public static void expandAllNodes(JTree tree, int startingIndex, int rowCount){
        for (int i = startingIndex; i < rowCount; ++i){
            tree.expandRow(i);
        }

        if (tree.getRowCount() != rowCount){
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

}
