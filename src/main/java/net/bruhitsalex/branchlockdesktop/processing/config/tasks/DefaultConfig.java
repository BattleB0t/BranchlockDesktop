package net.bruhitsalex.branchlockdesktop.processing.config.tasks;

import net.bruhitsalex.branchlockdesktop.processing.config.Config;
import net.bruhitsalex.branchlockdesktop.processing.config.GlobalSettings;
import net.bruhitsalex.branchlockdesktop.processing.utils.ConfigUtils;

import java.util.ArrayList;

public class DefaultConfig extends Config {

    public DefaultConfig() {
        super(
                new GlobalSettings(
                        GlobalSettings.MemberNameGenerationMode.ADAPTIVE,
                        false,
                        true
                ), new Tasks(
                        new Trimmer(false, false),
                        new StacktraceEncryption(false, ConfigUtils.generateStacktraceKey()),
                        new RemoveDebugInformation(false, false, false, false, false),
                        false,
                        false,
                        new DescriptorObfuscation(false, false, false, false, false),
                        new ControlFlowObfuscation(false, false),
                        false,
                        false,
                        new AntiDebug(false, false),
                        new Renamer(false, "b", false, false, false, false),
                        new ReferenceEncryption(false, ReferenceEncryption.Mode.REFLECTION, false, false, false),
                        false,
                        new StringEncryption(false, StringEncryption.Mode.COMPATIBILITY, 0),
                        new CrashRETools(false, false, false)
                ),
                new ObfuscationRanges(
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
    }

}
