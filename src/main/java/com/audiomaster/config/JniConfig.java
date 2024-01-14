package com.audiomaster.config;

import com.jni.compressorJUCE;
import com.jni.wavFileReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JniConfig {

    @Bean
    public wavFileReader wavFileReader() {
        return new wavFileReader();
    }

    @Bean
    public compressorJUCE compressorJUCE() {
        return new compressorJUCE();
    }
}
