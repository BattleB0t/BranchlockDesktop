package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.ObfuscationRanges;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.Tasks;

import java.io.File;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Config {

    private GlobalSettings globalSettings;
    private Tasks tasks;
    private ObfuscationRanges obfuscationRanges;
    private Dependencies dependencies;
    private File input, output;

}
