package com.audiomaster.service;

import com.audiomaster.audio.AudioBufferFloat;
import com.audiomaster.audio.AudioWrapper;
import com.audiomaster.audio.processor.compressorJuce;
import com.audiomaster.audio.processor.compressorLsp;
import com.audiomaster.audio.processorWrapper;
import com.audiomaster.dto.AudioContentDto;
import com.audiomaster.service.component.FileStore;
import com.audiomaster.service.component.jniApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class AudioMasteringService {
    private final jniApi jniApi;
    private final FileStore fileStore;

    public AudioContentDto processCompressorJuce(AudioContentDto audioContent) throws IOException {
        AudioWrapper wrapper = audioContent.toEntity();
        processorWrapper proc = wrapper.getProcessorList();
        // 파일 저장
        String outputFilename = fileStore.storeFile(audioContent);

        // Audio Buffer 읽기
        jniApi.getWavFileReader().loadWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("input.wav"));

        // Compressor 동작
        jniApi.getCompressorJUCE().processAndLoad(wrapper.getAudioBufferFloat(), (compressorJuce) proc);

        // Output Audio 저장
        jniApi.getWavFileReader().saveWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("output.wav"));

        return AudioContentDto.of(outputFilename);
    }

    public AudioContentDto processCompressorLsp(AudioContentDto audioContent) throws IOException {
        AudioWrapper wrapper = audioContent.toEntity();
        processorWrapper proc = wrapper.getProcessorList();
        // 파일 저장
        String outputFilename = fileStore.storeFile(audioContent);

        // Audio Buffer 읽기
        jniApi.getWavFileReader().loadWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("input.wav"));

        // Compressor 동작
        jniApi.getCompressorLSP().processAndLoad(wrapper.getAudioBufferFloat(), (compressorLsp) proc);

        // Output Audio 저장
        jniApi.getWavFileReader().saveWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("output.wav"));

        return AudioContentDto.of(outputFilename);
    }
}
