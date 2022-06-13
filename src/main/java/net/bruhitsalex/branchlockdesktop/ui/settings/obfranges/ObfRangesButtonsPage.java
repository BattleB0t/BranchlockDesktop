package net.bruhitsalex.branchlockdesktop.ui.settings.obfranges;

import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.ui.settings.ObfuscationRangesPane;

import javax.swing.*;
import java.awt.*;

@Getter
public class ObfRangesButtonsPage extends JPanel {

    private final ObfuscationRangesPane obfuscationRangesPane;
    private JButton addExclusion, removeExclusion, addInclusion, removeInclusion;

    public ObfRangesButtonsPage(ObfuscationRangesPane obfuscationRangesPane) {
        this.obfuscationRangesPane = obfuscationRangesPane;
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        initLayout();
    }

    private void initComponents() {
        addExclusion = new JButton("Add Exclusion");
        removeExclusion = new JButton("Remove Exclusion");
        addInclusion = new JButton("Add Inclusion");
        removeInclusion = new JButton("Remove Inclusion");
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(addExclusion)
                        .addGap(5, 5, 5)
                        .addComponent(removeExclusion)
                        .addGap(20, 20, 20)
                        .addComponent(addInclusion)
                        .addGap(5, 5, 5)
                        .addComponent(removeInclusion)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(addExclusion)
                        .addComponent(removeExclusion)
                        .addComponent(addInclusion)
                        .addComponent(removeInclusion)
        );

        setLayout(layout);
    }

}
