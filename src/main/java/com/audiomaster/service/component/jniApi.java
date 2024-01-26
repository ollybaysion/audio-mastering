package com.audiomaster.service.component;

import com.jni.compressorJUCE;
import com.jni.compressorLSP;
import com.jni.wavFileReader;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class jniApi {
    private final com.jni.wavFileReader wavFileReader;
    private final com.jni.compressorJUCE compressorJUCE;
    private final com.jni.compressorLSP compressorLSP;

    public jniApi() {
        this.wavFileReader = new wavFileReader();
        this.compressorJUCE = new compressorJUCE();
        this.compressorLSP = new compressorLSP();
    }
}
