package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CrashRETools {

    private boolean enabled;
    private boolean dontAbuseClassDebugInformation;
    private boolean disableArchiveCrashing;

}