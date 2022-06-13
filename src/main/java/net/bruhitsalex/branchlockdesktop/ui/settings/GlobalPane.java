package net.bruhitsalex.branchlockdesktop.ui.settings;

import net.bruhitsalex.branchlockdesktop.ui.settings.global.MemberNameGenerationModePane;
import net.bruhitsalex.branchlockdesktop.ui.settings.global.NoCompressionPane;
import net.bruhitsalex.branchlockdesktop.ui.settings.global.NoWatermarkPane;
import unknown.WrapLayout;

import javax.swing.*;
import java.awt.*;

public class GlobalPane extends JPanel {

    public GlobalPane() {
        WrapLayout flowLayout = new WrapLayout(FlowLayout.LEFT, 20, 10);
        setLayout(flowLayout);
        add(new MemberNameGenerationModePane());
        add(new NoCompressionPane());
        add(new NoWatermarkPane());
    }

}
