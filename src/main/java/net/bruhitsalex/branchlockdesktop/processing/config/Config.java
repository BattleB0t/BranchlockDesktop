package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Config {

    public Trimmer trimmer;
    public StacktraceEncryption stacktraceEncryption;

}
