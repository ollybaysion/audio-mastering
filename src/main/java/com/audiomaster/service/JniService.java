package com.audiomaster.service;

import com.audiomaster.audio.AudioBufferFloat;
import com.audiomaster.audio.processor.compressorLsp;
import com.audiomaster.audio.processorWrapper;
import com.audiomaster.service.jni.CompressorJUCE;
import com.audiomaster.service.jni.CompressorLSP;
import com.audiomaster.service.jni.WavFileReader;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class JniService {
    private final WavFileReader wavFileReader;
    private final CompressorJUCE compressorJUCE;
    private final CompressorLSP compressorLSP;

    public JniService(WavFileReader wavFileReader, CompressorJUCE compressorJUCE, CompressorLSP compressorLSP) {
        this.wavFileReader = wavFileReader;
        this.compressorJUCE = compressorJUCE;
        this.compressorLSP = compressorLSP;
    }

    public void process(String processorType, AudioBufferFloat audioBufferFloat, processorWrapper proc) {
        if(processorType.equalsIgnoreCase("compressorlsp")) {
            compressorLSP.processAndLoad(audioBufferFloat, (compressorLsp) proc);
        }
    }
}
