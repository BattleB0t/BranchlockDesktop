package net.bruhitsalex.branchlockdesktop.ui.settings;

import net.bruhitsalex.branchlockdesktop.processing.Processing;

import javax.swing.*;

public abstract class AbstractOptionPanel extends JPanel {

    public AbstractOptionPanel() {
        Processing.optionPanels.add(this);
    }

    public abstract void setOptionFromConfig();

}
