package com.audiomaster.service.jni;

import com.audiomaster.audio.AudioBufferFloat;
import com.audiomaster.audio.processor.compressorJuce;
import org.springframework.stereotype.Service;

@Service
public class CompressorJUCE {
    static {
        System.loadLibrary("compressorJUCE");
    }

    public CompressorJUCE() {
    }

    public native void processAndLoad(AudioBufferFloat audioBufferFloat, compressorJuce compressor_Juce_param);
}
