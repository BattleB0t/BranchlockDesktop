package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.AntiDebug;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class AntiDebugPane extends AbstractOptionPanel {

    private JCheckBox enabledBox, checkNoverifyBox;

    public AntiDebugPane() {
        super("Anti-Debug");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));
        components.add(checkNoverifyBox = new JCheckBox("Check noverify"));
    }

    @Override
    public void setOptionFromConfig() {
        AntiDebug antiDebug = Processing.getConfig().getTasks().getAntiDebug();
        enabledBox.setSelected(antiDebug.isEnabled());
        checkNoverifyBox.setSelected(antiDebug.isCheckNoverify());
    }

}
