package net.bruhitsalex.branchlockdesktop.ui.impl;

import lombok.Getter;

import javax.swing.*;

@Getter
public class SwingFileIO {

    private final JLabel label;
    private final JTextField path;
    private final JButton button;

    public SwingFileIO(String label) {
        this.label = new JLabel(label);
        this.label.setHorizontalAlignment(SwingConstants.RIGHT);
        path = new JTextField("");
        path.setEditable(false);
        button = new JButton();
        button.setIcon(UIManager.getIcon("Tree.closedIcon"));
    }

}
