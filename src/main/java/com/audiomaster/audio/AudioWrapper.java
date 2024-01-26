package com.audiomaster.audio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AudioWrapper {

    private AudioBufferFloat audioBufferFloat;
    private processorWrapper processorList;

    public AudioWrapper(processorWrapper processorList) {
        audioBufferFloat = new AudioBufferFloat();
        this.processorList = processorList;
    }
}
