package net.bruhitsalex.branchlockdesktop.processing.obfsettings;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Config {

    private GlobalSettings globalSettings;
    private Tasks tasks;
    private ObfuscationRanges obfuscationRanges;

}
