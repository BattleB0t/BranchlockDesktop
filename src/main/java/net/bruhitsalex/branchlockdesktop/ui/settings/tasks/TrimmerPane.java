package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class TrimmerPane extends AbstractOptionPanel {

    private JCheckBox enabledBox;
    private JCheckBox removeMethodsEntirelyBox;

    public TrimmerPane() {
        super("Trimmer");
    }

    @Override
    public void initComponents() {
        enabledBox = new JCheckBox("Enabled");
        components.add(enabledBox);

        removeMethodsEntirelyBox = new JCheckBox("Remove methods entirely");
        components.add(removeMethodsEntirelyBox);
    }

    @Override
    public void setOptionFromConfig() {
        enabledBox.setSelected(Processing.getConfig().getTasks().getTrimmer().isEnabled());
        removeMethodsEntirelyBox.setSelected(Processing.getConfig().getTasks().getTrimmer().isRemoveMethodsEntirely());
    }

}
