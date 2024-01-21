package com.jni;

import com.audiomaster.audio.AudioBufferFloat;
import com.audiomaster.audio.processor.compressor;

public class compressorJUCE {
    static {
        System.loadLibrary("compressorJUCE");
    }

    public compressorJUCE() {
    }

    public native void processAndLoad(AudioBufferFloat audioBufferFloat, compressor compressor_param);
}
