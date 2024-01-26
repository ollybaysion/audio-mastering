package com.jni;

import com.audiomaster.audio.AudioBufferFloat;
import com.audiomaster.audio.processor.compressorLsp;

public class compressorLSP {
    static {
        System.loadLibrary("compressorLSP");
    }

    public compressorLSP() {
    }

    public native void processAndLoad(AudioBufferFloat audioBufferFloat, compressorLsp compressor_param);
}
