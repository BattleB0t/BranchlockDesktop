package net.bruhitsalex.branchlockdesktop.ui.settings.tasks;

import net.bruhitsalex.branchlockdesktop.processing.Processing;
import net.bruhitsalex.branchlockdesktop.processing.config.CrashRETools;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import javax.swing.*;

public class CrashREToolsPane extends AbstractOptionPanel {

    private JCheckBox enabledBox, dontAbuseClassDebugInfoBox, disableArchiveCrashingBox;

    public CrashREToolsPane() {
        super("Crash RE-Tools");
    }

    @Override
    public void initComponents() {
        components.add(enabledBox = new JCheckBox("Enabled"));
        components.add(dontAbuseClassDebugInfoBox = new JCheckBox("Don't abuse class debug information"));
        components.add(disableArchiveCrashingBox = new JCheckBox("Disable archive crashing"));
    }

    @Override
    public void setOptionFromConfig() {
        CrashRETools crashRETools = Processing.getConfig().getTasks().getCrashRETools();
        enabledBox.setSelected(crashRETools.isEnabled());
        dontAbuseClassDebugInfoBox.setSelected(crashRETools.isDontAbuseClassDebugInformation());
        disableArchiveCrashingBox.setSelected(crashRETools.isDisableArchiveCrashing());
    }

}
