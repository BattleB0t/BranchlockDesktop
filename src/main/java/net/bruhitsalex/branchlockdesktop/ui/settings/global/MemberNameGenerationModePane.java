package net.bruhitsalex.branchlockdesktop.ui.settings.global;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.GlobalSettings;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class MemberNameGenerationModePane extends AbstractOptionPanel {

    private JComboBox<GlobalSettings.MemberNameGenerationMode> modeBox;

    public MemberNameGenerationModePane() {
        super("Member Name Generation Mode");
    }

    @Override
    public void initComponents() {
        components.add(modeBox = new JComboBox<>(GlobalSettings.MemberNameGenerationMode.values()));
    }

    @Override
    public void setOptionFromConfig() {
        modeBox.setSelectedItem(Processing.getConfig().getGlobalSettings().getMemberNameGenerationMode());
    }

}
