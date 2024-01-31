package com.audiomaster.service.jni;

import com.audiomaster.audio.AudioBufferFloat;
import com.audiomaster.audio.processor.compressorLsp;
import org.springframework.stereotype.Service;

@Service
public class CompressorLSP {
    static {
        System.loadLibrary("compressorLSP");
    }

    public CompressorLSP() {
    }

    public native void processAndLoad(AudioBufferFloat audioBufferFloat, compressorLsp compressor_param);
}
