package com.audiomaster.service;

import com.audiomaster.dto.AudioContentDto;
import com.audiomaster.audio.AudioWrapper;
import com.audiomaster.audio.processor.compressor;
import com.audiomaster.service.component.FileStore;
import com.jni.compressorJUCE;
import com.jni.wavFileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class AudioMasteringService {

    private final wavFileReader wavFileReader;
    private final compressorJUCE compressorJuceJni;
    private final FileStore fileStore;

    public AudioContentDto processCompressor(AudioContentDto audioContent) throws IOException {
        AudioWrapper wrapper = audioContent.toEntity();
        // 파일 저장
        String outputFilename = fileStore.storeFile(audioContent);

        // Audio Buffer 읽기
        wavFileReader.loadWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("input.wav"));

        // Compressor 동작
        compressorJuceJni.processAndLoad(wrapper.getAudioBufferFloat(), (compressor) wrapper.getProcessorList());

        // Output Audio 저장
        wavFileReader.saveWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("output.wav"));

        return AudioContentDto.of(outputFilename);
    }
}
