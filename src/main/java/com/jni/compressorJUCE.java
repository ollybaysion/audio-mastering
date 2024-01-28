package com.jni;

import com.audiomaster.audio.AudioBufferFloat;
import com.audiomaster.audio.processor.compressorJuce;

public class compressorJUCE {
    static {
        System.loadLibrary("compressorJUCE");
    }

    public compressorJUCE() {
    }

    public native void processAndLoad(AudioBufferFloat audioBufferFloat, compressorJuce compressor_Juce_param);
}
