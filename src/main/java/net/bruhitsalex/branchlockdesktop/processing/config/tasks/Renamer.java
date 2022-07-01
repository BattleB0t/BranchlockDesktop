package net.bruhitsalex.branchlockdesktop.processing.config.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Renamer {

    private boolean enabled;
    private String defaultPackageName = "b";
    private boolean keepClassNames;
    private boolean keepLocalVariables;
    private boolean removeSerialVersionIdentifiers;
    private boolean renameMainClasses;

}
