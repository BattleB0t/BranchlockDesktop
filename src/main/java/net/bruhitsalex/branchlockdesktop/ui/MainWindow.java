package net.bruhitsalex.branchlockdesktop.ui;

import net.bruhitsalex.branchlockdesktop.ui.processing.ProcessingPane;
import net.bruhitsalex.branchlockdesktop.ui.settings.ConfigPane;
import net.bruhitsalex.branchlockdesktop.ui.utils.UIUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ProcessingPane proccessingPane;
    private ConfigPane configPane;

    public MainWindow() {
        setTitle("Branchlock Desktop");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            setIconImage(ImageIO.read(getClass().getClassLoader().getResource("images/icon.png")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));
        initComponents();

        UIUtils.centreWindow(this);
        pack();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.15);

        proccessingPane = new ProcessingPane();
        splitPane.setLeftComponent(proccessingPane);
        configPane = new ConfigPane();
        splitPane.setRightComponent(configPane);

        mainPanel.add(splitPane, BorderLayout.CENTER);
    }

}
