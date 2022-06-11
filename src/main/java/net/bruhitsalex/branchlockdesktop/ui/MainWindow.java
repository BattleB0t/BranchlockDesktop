package net.bruhitsalex.branchlockdesktop.ui;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Branchlock Desktop");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            setIconImage(ImageIO.read(getClass().getClassLoader().getResource("images/icon.png")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        UIUtils.centreWindow(this);
        pack();
    }

}
