package net.bruhitsalex.branchlockdesktop.ui;

import javax.swing.*;
import java.awt.*;

public class UIUtils {

    public static void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 800) / 2);
        int y = (int) ((dimension.getHeight() - 500) / 2) - 50;
        frame.setLocation(x, y);
    }

}
