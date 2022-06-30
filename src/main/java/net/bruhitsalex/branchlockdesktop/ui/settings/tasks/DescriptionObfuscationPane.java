package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.DescriptorObfuscation;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class DescriptionObfuscationPane extends AbstractOptionPanel {

    private JCheckBox enabledBox;
    private JCheckBox keepFieldsBox;
    private JCheckBox keepMethodSignaturesBox;
    private JCheckBox keepIntTypesBox;
    private JCheckBox noExtraIntInheritBox;

    public DescriptionObfuscationPane() {
        super("Description Obfuscation");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));
        components.add(keepFieldsBox = new JCheckBox("Keep fields"));
        components.add(keepMethodSignaturesBox = new JCheckBox("Keep method signatures"));
        components.add(keepIntTypesBox = new JCheckBox("Keep int types"));
        components.add(noExtraIntInheritBox = new JCheckBox("No extra int inherit"));
    }

    @Override
    public void setOptionFromConfig() {
        DescriptorObfuscation descriptorObfuscation = Processing.getConfig().getTasks().getDescriptorObfuscation();
        enabledBox.setSelected(descriptorObfuscation.isEnabled());
        keepFieldsBox.setSelected(descriptorObfuscation.isKeepFields());
        keepMethodSignaturesBox.setSelected(descriptorObfuscation.isKeepMethodSignatures());
        keepIntTypesBox.setSelected(descriptorObfuscation.isKeepIntTypes());
        noExtraIntInheritBox.setSelected(descriptorObfuscation.isNoExtraIntInherit());
    }

}
