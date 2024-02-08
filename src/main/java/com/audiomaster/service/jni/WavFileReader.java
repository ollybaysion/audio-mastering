package com.audiomaster.service.jni;

import com.audiomaster.audio.AudioBuffer;
import org.springframework.stereotype.Service;

@Service
public class WavFileReader {
    static {
        System.loadLibrary("wavFileReader");
    }

    public WavFileReader() {
    }

    public native void loadWavAudioFile(AudioBuffer audioBufferFloat, String inputPath);
    public native void saveWavAudioFile(AudioBuffer audioBufferFloat, String savePath);
}
