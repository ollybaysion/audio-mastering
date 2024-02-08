package com.audiomaster.audio;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum ProcessorType {
    PARAEQ("Parameteric EQ", "paraeq", 0, List.of("Filter Type", "Frequency", "Gain", "Slope", "Quality")),
    DRC("Dynamic Range Compressor", "drc", 1, List.of("Attack Threshold", "Release Threshold", "Attack Time", "Release Time", "Ratio", "Knee"));

    private String typeName;
    private String typeUrl;
    private int typeId;
    private List<String> paramText;

    ProcessorType(String typeName, String typeUrl, int typeId, List<String> paramText) {
        this.typeName = typeName;
        this.typeUrl = typeUrl;
        this.typeId = typeId;
        this.paramText = paramText;
    }

    public static ProcessorType findByTypeName(String typeName) {
        return Arrays.stream(ProcessorType.values())
                .filter(processorType -> processorType.getTypeName().equalsIgnoreCase(typeName))
                .findAny()
                .orElseThrow();
    }

    public static ProcessorType findByTypeUrl(String typeUrl) {
        return Arrays.stream(ProcessorType.values())
                .filter(processorType -> processorType.getTypeUrl().equalsIgnoreCase(typeUrl))
                .findAny()
                .orElseThrow();
    }
}
