package net.bruhitsalex.branchlockdesktop.processing;

import lombok.Getter;
import lombok.Setter;
import net.bruhitsalex.branchlockdesktop.processing.config.Config;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.DefaultConfig;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;
import net.bruhitsalex.branchlockdesktop.ui.settings.LogPane;
import net.bruhitsalex.branchlockdesktop.ui.settings.obfranges.ObfuscationRangesTree;

import java.util.ArrayList;
import java.util.List;

public class Processing {

    @Getter private static final List<AbstractOptionPanel> optionPanels = new ArrayList<>();
    @Getter @Setter private static Config config = new DefaultConfig();

    public static void updatePanelOptions() {
        optionPanels.forEach(AbstractOptionPanel::setOptionFromConfig);
        ObfuscationRangesTree.INSTANCE.setOptionFromConfig();
        LogPane.addLine(LogPane.Type.GUI, "Updated UI elements.");
    }

}
