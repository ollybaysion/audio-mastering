package com.audiomaster.domain.constant;

import lombok.Getter;

public enum AudioProcessStatus {
    OK("완료", true);

    @Getter private final String description;
    @Getter private final Boolean update;

    AudioProcessStatus(String description, Boolean update) {
        this.description = description;
        this.update = update;
    }

}