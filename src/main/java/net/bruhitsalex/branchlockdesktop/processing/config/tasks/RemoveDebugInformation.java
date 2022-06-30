package net.bruhitsalex.branchlockdesktop.processing.config.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RemoveDebugInformation {

    private boolean enabled;
    private boolean keepStacktraceInformation;
    private boolean removeAnnotations;
    private boolean keepLocalVariables;
    private boolean keepSignatures;

}
