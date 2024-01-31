package com.audiomaster.service.jni;

import com.audiomaster.audio.AudioBufferFloat;
import org.springframework.stereotype.Service;

@Service
public class WavFileReader {
    static {
        System.loadLibrary("wavFileReader");
    }

    public WavFileReader() {
    }

    public native void loadWavAudioFile(AudioBufferFloat audioBufferFloat, String inputPath);
    public native void saveWavAudioFile(AudioBufferFloat audioBufferFloat, String savePath);
}
