package net.bruhitsalex.branchlockdesktop.ui.settings;

import net.bruhitsalex.branchlockdesktop.processing.Processing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractOptionPanel extends JPanel {

    public ArrayList<JComponent> components = new ArrayList<>();

    private final String title;
    public AbstractOptionPanel(String title) {
        this.title = title;
        initComponents();
        initLayout();
        //setBorder(BorderFactory.createLineBorder(Color.darkGray));
        Processing.getOptionPanels().add(this);
    }

    public void initLayout() {
        JPanel options = new JPanel();
        options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
        components.forEach(jComponent -> {
            jComponent.setAlignmentX(Component.LEFT_ALIGNMENT);
            options.add(jComponent);
        });

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD).deriveFont(14f));

        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(titleLabel)
                        .addGap(2, 2, 2)
                        .addComponent(options)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel)
                        .addComponent(options)
        );

        setLayout(layout);
    }

    public abstract void initComponents();
    public abstract void setOptionFromConfig();

}
