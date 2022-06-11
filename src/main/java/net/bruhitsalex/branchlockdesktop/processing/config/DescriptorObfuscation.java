package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DescriptorObfuscation {

    private boolean enabled;
    private boolean keepFields;
    private boolean keepMethodSignatures;
    private boolean keepIntTypes;
    private boolean noExtraIntInherit;

}
