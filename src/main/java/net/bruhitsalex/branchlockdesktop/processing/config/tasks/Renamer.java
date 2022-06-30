package net.bruhitsalex.branchlockdesktop.processing.config.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Renamer {

    private boolean enabled;
    private String defaultPackageName = "b";
    private boolean keepClassNames;
    private boolean keepLocalVariables;
    private boolean removeSerialVersionIdentifiers;
    private boolean renameMainClasses;

}
