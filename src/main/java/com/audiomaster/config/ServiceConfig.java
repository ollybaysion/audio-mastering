package com.audiomaster.config;

import com.audiomaster.service.component.FileStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public FileStore FileStore() {
        return new FileStore();
    }
}
