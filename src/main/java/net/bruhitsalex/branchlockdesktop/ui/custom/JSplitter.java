package net.bruhitsalex.branchlockdesktop.ui.custom;

import javax.swing.*;
import java.awt.*;

public class JSplitter extends JPanel {

    public JSplitter(int height) {
        setMaximumSize(new Dimension(Short.MAX_VALUE, height));
        setMinimumSize(new Dimension(10, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

}
