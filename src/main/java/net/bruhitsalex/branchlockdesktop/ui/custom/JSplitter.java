package net.bruhitsalex.branchlockdesktop.ui.custom;

import javax.swing.*;
import java.awt.*;

public class JSplitter extends JPanel {

    private static final Color COLOR = new Color(64, 64, 64, 120);

    public JSplitter(int height) {
        setMaximumSize(new Dimension(Short.MAX_VALUE, height));
        setMinimumSize(new Dimension(10, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}
