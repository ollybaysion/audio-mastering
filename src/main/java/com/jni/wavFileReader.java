package com.jni;

import com.audiomaster.plugin.AudioBufferFloat;

public class wavFileReader {
    static {
        System.loadLibrary("wavFileReader");
    }

    public wavFileReader() {
    }

    public native void loadWavAudioFile(AudioBufferFloat audioBufferFloat);
    public native void saveWavAudioFile(AudioBufferFloat audioBufferFloat);
}
