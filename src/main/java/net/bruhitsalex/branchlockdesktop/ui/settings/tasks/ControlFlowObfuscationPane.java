package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.ControlFlowObfuscation;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class ControlFlowObfuscationPane extends AbstractOptionPanel {

    private JCheckBox enabledBox, heavyBox;

    public ControlFlowObfuscationPane() {
        super("Control Flow Obfuscation");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));
        components.add(heavyBox = new JCheckBox("Heavy"));
    }

    @Override
    public void setOptionFromConfig() {
        ControlFlowObfuscation flowObfuscation = Processing.getConfig().getTasks().getControlFlowObfuscation();
        enabledBox.setSelected(flowObfuscation.isEnabled());
        heavyBox.setSelected(flowObfuscation.isHeavy());
    }

}
