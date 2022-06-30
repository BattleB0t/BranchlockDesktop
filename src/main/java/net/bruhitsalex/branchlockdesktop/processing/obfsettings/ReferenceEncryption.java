package net.bruhitsalex.branchlockdesktop.processing.obfsettings;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReferenceEncryption {

    private boolean enabled;
    private Mode mode = Mode.REFLECTION;
    private boolean ignoreMethods;
    private boolean ignoreFields;
    private boolean forceUnresolvedEncryption;

    public enum Mode {
        REFLECTION,
        DYNAMIC
    }

}
