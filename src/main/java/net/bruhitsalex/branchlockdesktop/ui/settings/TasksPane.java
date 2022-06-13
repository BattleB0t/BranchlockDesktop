package net.bruhitsalex.branchlockdesktop.ui.settings;

import net.bruhitsalex.branchlockdesktop.ui.settings.tasks.*;
import unknown.WrapLayout;

import javax.swing.*;
import java.awt.*;

public class TasksPane extends JPanel {

    public TasksPane() {
        WrapLayout flowLayout = new WrapLayout(FlowLayout.LEFT, 20, 10);
        setLayout(flowLayout);
        add(new TrimmerPane());
        add(new StacktraceEncryptionPane());
        add(new RemoveDebugInformationPane());
        add(new RuntimeCoveragePane());
        add(new NumberObfuscationPane());
        add(new DescriptionObfuscationPane());
        add(new ControlFlowObfuscationPane());
        add(new ScrambleCodeLogicPane());
        add(new GeneralizeAccessPane());
        add(new AntiDebugPane());
        add(new RenamerPane());
        add(new ReferenceEncryptionPane());
        add(new ShuffleClassMembersPane());
        add(new StringEncryptionPane());
        add(new CrashREToolsPane());
    }

}
