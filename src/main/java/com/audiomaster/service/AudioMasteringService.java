package com.audiomaster.service;

import com.audiomaster.plugin.channel;
import com.audiomaster.plugin.compressor;
import com.jni.compressorJUCE;
import com.jni.wavFileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class AudioMasteringService {

    private final wavFileReader wavFileReader;
    private final compressorJUCE compressorJuceJni;

    private static String AudioRepositoryPath = "/src/main";
    private channel channel;

    public void saveAudioFile(MultipartFile[] AudioInputFile) {

        for(MultipartFile multipartFile : AudioInputFile) {
            File file = new File(AudioRepositoryPath, multipartFile.getOriginalFilename());

            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            channel.getAudioBufferFloat().setFilePath(file.getAbsolutePath());
        }

        wavFileReader.loadWavAudioFile(channel.getAudioBufferFloat());
        compressorJuceJni.processAndLoad(channel.getAudioBufferFloat(), new compressor(0.1, 0.1, 0.1, 0.1, 0.1));
        wavFileReader.saveWavAudioFile(channel.getAudioBufferFloat(), "");
    }
}
