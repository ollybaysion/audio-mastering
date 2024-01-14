package com.audiomaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AudioMasteringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudioMasteringApplication.class, args);
	}

}
