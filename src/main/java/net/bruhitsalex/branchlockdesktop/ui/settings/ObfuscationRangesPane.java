package net.bruhitsalex.branchlockdesktop.ui.settings;

import lombok.Getter;
import net.bruhitsalex.branchlockdesktop.ui.settings.obfranges.ObfRangesButtonsPage;
import net.bruhitsalex.branchlockdesktop.ui.settings.obfranges.ObfuscationRangesTree;

import javax.swing.*;
import java.awt.*;

@Getter
public class ObfuscationRangesPane extends JLayeredPane {

    private final ObfuscationRangesTree tree;
    private final ObfRangesButtonsPage buttonsPage;

    public ObfuscationRangesPane() {
        tree = new ObfuscationRangesTree();
        tree.setBounds(0, 0, Short.MAX_VALUE, Short.MAX_VALUE);

        buttonsPage = new ObfRangesButtonsPage(this);
        buttonsPage.setBounds(10, 10, 50, 50);
        buttonsPage.setBackground(Color.red);

        add(tree, JLayeredPane.DEFAULT_LAYER);
        add(buttonsPage, JLayeredPane.POPUP_LAYER);

        setLayout(null);
    }

}
