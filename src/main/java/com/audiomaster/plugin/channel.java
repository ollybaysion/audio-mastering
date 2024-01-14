package com.audiomaster.plugin;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class channel {

    private AudioBufferFloat audioBufferFloat;
    private List<processor> processorList;

    public channel() {
        audioBufferFloat = new AudioBufferFloat();
    }
    public channel(List<processor> processorList) {
        this.processorList = processorList;
    }

    public static channel of(List<processor> processorList) {
        return new channel(processorList);
    }

    public List<List<String>> toElement() {
        List<List<String>> list = new ArrayList<>();
        for(processor iter : processorList) {
            list.add(iter.toElement());
        }

        return list;
    }
}
