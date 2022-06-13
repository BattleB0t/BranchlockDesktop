package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.Renamer;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class RenamerPane extends AbstractOptionPanel {

    private JCheckBox enabledBox;
    private JTextField defaultPackageNameField;
    private JCheckBox keepClassNamesBox, keepLocalVariablesBox,
        removeSerialVersionIdentifiersBox, renameMainClassesBox;

    public RenamerPane() {
        super("Renamer");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));

        JPanel encapsulate = new JPanel();
        encapsulate.setBorder(BorderFactory.createEmptyBorder());
        defaultPackageNameField = new JTextField("Default package name");
        encapsulate.add(defaultPackageNameField);
        encapsulate.add(new JLabel("Default package name"));
        components.add(encapsulate);

        components.add(keepClassNamesBox = new JCheckBox("Keep class names"));
        components.add(keepLocalVariablesBox = new JCheckBox("Keep local variables"));
        components.add(removeSerialVersionIdentifiersBox = new JCheckBox("Remove serial version identifiers"));
        components.add(renameMainClassesBox = new JCheckBox("Rename main classes"));
    }

    @Override
    public void setOptionFromConfig() {
        Renamer renamer = Processing.getConfig().getTasks().getRenamer();
        enabledBox.setSelected(renamer.isEnabled());
        defaultPackageNameField.setText(renamer.getDefaultPackageName());
        keepClassNamesBox.setSelected(renamer.isKeepClassNames());
        keepLocalVariablesBox.setSelected(renamer.isKeepLocalVariables());
        removeSerialVersionIdentifiersBox.setSelected(renamer.isRemoveSerialVersionIdentifiers());
        renameMainClassesBox.setSelected(renamer.isRenameMainClasses());
    }

}
