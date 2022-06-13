package net.bruhitsalex.branchlockdesktop.ui.settings.global;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class NoCompressionPane extends AbstractOptionPanel {

    private JCheckBox enabledBox;

    public NoCompressionPane() {
        super("No Compression");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));
    }

    @Override
    public void setOptionFromConfig() {
        enabledBox.setSelected(Processing.getConfig().getGlobalSettings().isNoCompression());
    }

}
