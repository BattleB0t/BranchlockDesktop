package net.bruhitsalex.branchlockdesktop.processing.config.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RemoveDebugInformation {

    private boolean enabled;
    private boolean keepStacktraceInformation;
    private boolean removeAnnotations;
    private boolean keepLocalVariables;
    private boolean keepSignatures;

}
