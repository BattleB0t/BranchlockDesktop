package net.bruhitsalex.branchlockdesktop.processing.config.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DescriptorObfuscation {

    private boolean enabled;
    private boolean keepFields;
    private boolean keepMethodSignatures;
    private boolean keepIntTypes;
    private boolean noExtraIntInherit;

}
