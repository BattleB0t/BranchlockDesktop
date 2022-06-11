package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ControlFlowObfuscation {

    private boolean enabled;
    private boolean heavy;

}
