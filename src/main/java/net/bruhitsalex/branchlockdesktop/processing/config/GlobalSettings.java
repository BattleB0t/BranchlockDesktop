package net.bruhitsalex.branchlockdesktop.processing.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GlobalSettings {

    private MemberNameGenerationMode memberNameGenerationMode = MemberNameGenerationMode.ADAPTIVE;
    private boolean noCompression;
    private boolean noWatermark;

    public enum MemberNameGenerationMode {
        ADAPTIVE,
        THIN_LETTERS,
        IDEOGRAPHIC,
        ARABIC,
        ALPHA_NUMERIC,
        NON_PRINTABLE;
    }

}
