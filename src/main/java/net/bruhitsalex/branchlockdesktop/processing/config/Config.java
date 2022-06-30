package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.ObfuscationRanges;
import net.bruhitsalex.branchlockdesktop.processing.config.tasks.Tasks;

@AllArgsConstructor
@Data
public class Config {

    private GlobalSettings globalSettings;
    private Tasks tasks;
    private ObfuscationRanges obfuscationRanges;


}
