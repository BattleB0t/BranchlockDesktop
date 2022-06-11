package net.bruhitsalex.branchlockdesktop.ui.impl;

import darrylbu.icon.StretchIcon;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

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
        button.setIcon(new StretchIcon(getClass().getClassLoader().getResource("images/folder.png")));
    }

}
