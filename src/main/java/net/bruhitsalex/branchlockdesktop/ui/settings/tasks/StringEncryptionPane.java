package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.config.StringEncryption;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class StringEncryptionPane extends AbstractOptionPanel {

    private JCheckBox enabledBox;
    private JComboBox<StringEncryption.Mode> modeBox;
    private JSpinner minLengthBox;

    public StringEncryptionPane() {
        super("String Encryption");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));

        JPanel encapsulate = new JPanel();
        encapsulate.setBorder(BorderFactory.createEmptyBorder());
        modeBox = new JComboBox<>(StringEncryption.Mode.values());
        encapsulate.add(modeBox);
        encapsulate.add(new JLabel("Mode"));
        components.add(encapsulate);

        JPanel encapsulate2 = new JPanel();
        encapsulate2.setBorder(BorderFactory.createEmptyBorder());
        minLengthBox = new JSpinner();
        encapsulate2.add(minLengthBox);
        encapsulate2.add(new JLabel("Minimum length"));
        components.add(encapsulate2);
    }

    @Override
    public void setOptionFromConfig() {

    }

}
