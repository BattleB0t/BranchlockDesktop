package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.RemoveDebugInformation;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class RemoveDebugInformationPane extends AbstractOptionPanel {

    private JCheckBox enabledBox, keepStacktraceInfoBox,
        removeAnnotationsBox, keepLocalVariablesBox, keepSignaturesBox;

    public RemoveDebugInformationPane() {
        super("Remove Debug Information");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));
        components.add(keepStacktraceInfoBox = new JCheckBox("Keep stacktrace information"));
        components.add(removeAnnotationsBox = new JCheckBox("Remove annotations"));
        components.add(keepLocalVariablesBox = new JCheckBox("Keep local variables"));
        components.add(keepSignaturesBox = new JCheckBox("Keep signatures"));
    }

    @Override
    public void setOptionFromConfig() {
        RemoveDebugInformation removeDebugInformation = Processing.getConfig().getTasks().getRemoveDebugInformation();
        enabledBox.setSelected(removeDebugInformation.isEnabled());
        keepStacktraceInfoBox.setSelected(removeDebugInformation.isKeepStacktraceInformation());
        removeAnnotationsBox.setSelected(removeDebugInformation.isRemoveAnnotations());
        keepLocalVariablesBox.setSelected(removeDebugInformation.isKeepLocalVariables());
        keepSignaturesBox.setSelected(removeDebugInformation.isKeepSignatures());
    }

}
