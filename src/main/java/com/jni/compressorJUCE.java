package com.jni;

import com.audiomaster.plugin.AudioBufferFloat;
import com.audiomaster.plugin.compressor;

public class compressorJUCE {
    static {
        System.loadLibrary("compressorJUCE");
    }

    public compressorJUCE() {
    }

    public native void processAndLoad(AudioBufferFloat audioBufferFloat, compressor compressor_param);
}
