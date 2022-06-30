package net.bruhitsalex.branchlockdesktop.processing.obfsettings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ObfuscationRanges {

    private List<String> exclusions;
    private List<String> inclusions;

}
