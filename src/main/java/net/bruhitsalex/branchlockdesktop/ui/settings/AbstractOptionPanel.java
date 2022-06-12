package net.bruhitsalex.branchlockdesktop.ui.settings;

import net.bruhitsalex.branchlockdesktop.processing.Processing;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public abstract class AbstractOptionPanel extends JPanel {

    private final String title;
    public AbstractOptionPanel(String title) {
        this.title = title;
        setBorder(BorderFactory.createLineBorder(Color.darkGray));
        Processing.getOptionPanels().add(this);
    }

    public void initLayout(Component... components) {
        JPanel options = new JPanel();
        options.setLayout(new FlowLayout(FlowLayout.LEADING));
        Arrays.stream(components).forEach(options::add);

        JLabel titleLabel = new JLabel("  " + title + "  ");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD).deriveFont(14f));

        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(titleLabel)
                        .addComponent(options)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(titleLabel)
                        .addComponent(options)
        );

        setLayout(layout);
    }
    public abstract void setOptionFromConfig();

}
