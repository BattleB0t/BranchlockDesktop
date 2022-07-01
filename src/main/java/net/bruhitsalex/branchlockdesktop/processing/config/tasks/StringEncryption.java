package net.bruhitsalex.branchlockdesktop.processing.config.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StringEncryption {

    private boolean enabled;
    private Mode mode = Mode.COMPATIBILITY;
    private int minimumLength;

    public enum Mode {
        COMPATIBILITY,
        ENHANCED
    }

}
