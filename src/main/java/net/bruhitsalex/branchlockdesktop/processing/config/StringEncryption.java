package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StringEncryption {

    private boolean enabled;
    private Mode mode = Mode.COMPATIBILITY;
    private int minimumLength;

    public enum Mode {
        COMPATIBILITY,
        ENHANCED
    }

}
