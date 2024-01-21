package com.audiomaster.audio;

import com.audiomaster.audio.processor.processor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AudioWrapper {

    private AudioBufferFloat audioBufferFloat;
    private processor processorList;

    public AudioWrapper(processor processorList) {
        audioBufferFloat = new AudioBufferFloat();
        this.processorList = processorList;
    }
}
