package net.bruhitsalex.branchlockdesktop.processing;

import lombok.Getter;
import lombok.Setter;
import net.bruhitsalex.branchlockdesktop.processing.config.Config;
import net.bruhitsalex.branchlockdesktop.processing.config.DefaultConfig;
import net.bruhitsalex.branchlockdesktop.ui.settings.AbstractOptionPanel;

import java.util.ArrayList;
import java.util.List;

public class Processing {

    @Getter private static List<AbstractOptionPanel> optionPanels = new ArrayList<>();
    @Getter @Setter private static Config config = new DefaultConfig();

    public static void updatePanelOptions() {
        optionPanels.forEach(AbstractOptionPanel::setOptionFromConfig);
    }

}
