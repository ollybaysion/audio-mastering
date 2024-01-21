package com.jni;

import com.audiomaster.audio.AudioBufferFloat;

public class wavFileReader {
    static {
        System.loadLibrary("wavFileReader");
    }

    public wavFileReader() {
    }

    public native void loadWavAudioFile(AudioBufferFloat audioBufferFloat, String inputPath);
    public native void saveWavAudioFile(AudioBufferFloat audioBufferFloat, String savePath);
}
