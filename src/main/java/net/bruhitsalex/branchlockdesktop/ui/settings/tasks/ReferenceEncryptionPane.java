package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.obfsettings.ReferenceEncryption;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class ReferenceEncryptionPane extends AbstractOptionPanel {

    private JCheckBox enabledBox;
    private JComboBox<ReferenceEncryption.Mode> modeBox;
    private JCheckBox ignoreMethodsBox, ignoreFieldsBox, forceUnresolvedEncryptionBox;

    public ReferenceEncryptionPane() {
        super("Reference Encryption");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));

        JPanel encapsulate = new JPanel();
        encapsulate.setBorder(BorderFactory.createEmptyBorder());
        modeBox = new JComboBox<>(ReferenceEncryption.Mode.values());
        encapsulate.add(modeBox);
        encapsulate.add(new JLabel(" Mode"));
        components.add(encapsulate);

        components.add(ignoreMethodsBox = new JCheckBox("Ignore methods"));
        components.add(ignoreFieldsBox = new JCheckBox("Ignore fields"));
        components.add(forceUnresolvedEncryptionBox = new JCheckBox("Force unresolved encryption"));
    }

    @Override
    public void setOptionFromConfig() {
        ReferenceEncryption encryption = Processing.getConfig().getTasks().getReferenceEncryption();
        enabledBox.setSelected(encryption.isEnabled());
        modeBox.setSelectedItem(encryption.getMode());
        ignoreMethodsBox.setSelected(encryption.isIgnoreMethods());
        ignoreFieldsBox.setSelected(encryption.isIgnoreFields());
        forceUnresolvedEncryptionBox.setSelected(encryption.isForceUnresolvedEncryption());
    }

}
