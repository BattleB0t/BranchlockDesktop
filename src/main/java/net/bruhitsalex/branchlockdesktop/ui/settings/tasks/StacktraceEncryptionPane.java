package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.obfsettings.ConfigUtils;
import net.bruhitsalex.branchlockdesktop.processing.obfsettings.StacktraceEncryption;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class StacktraceEncryptionPane extends AbstractOptionPanel {

    private JCheckBox enabledBox;
    private JTextField encryptionKeyField;

    public StacktraceEncryptionPane() {
        super("Stacktrace Encryption");
    }

    @Override
    public void initComponents() {
        enabledBox = new JCheckBox("Enabled");
        components.add(enabledBox);

        JPanel encapsulate = new JPanel();
        encapsulate.setBorder(BorderFactory.createEmptyBorder());
        encryptionKeyField = new JTextField(ConfigUtils.generateStacktraceKey());
        encapsulate.add(encryptionKeyField);
        encapsulate.add(new JLabel(" Key"));
        components.add(encapsulate);
    }

    @Override
    public void setOptionFromConfig() {
        StacktraceEncryption stacktraceEncryption = Processing.getConfig().getTasks().getStacktraceEncryption();
        enabledBox.setSelected(stacktraceEncryption.isEnabled());
        encryptionKeyField.setText(stacktraceEncryption.getEncryptionKey());
    }

}
