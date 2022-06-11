package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StacktraceEncryption {

    private boolean enabled;
    private String encryptionKey;

}
