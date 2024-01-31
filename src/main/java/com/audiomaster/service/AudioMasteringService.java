package com.audiomaster.service;

import com.audiomaster.audio.AudioWrapper;
import com.audiomaster.audio.processorWrapper;
import com.audiomaster.dto.request.AudioFormRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AudioMasteringService {
    private final JniService jniService;
    private final FileStore fileStore;

    public AudioMasteringService(JniService jniService, FileStore fileStore) {
        this.jniService = jniService;
        this.fileStore = fileStore;
    }

    public List<String> getProcessorList() {
        return List.of("CompressorLsp", "EQ");
    }

    public AudioFormRequest getRequest(String processorType) {
        return AudioFormRequest.of(processorType);
    }

    public List<String> getParams(String processorType) {
        return List.of(
                "Attack Threshold",
                "Release Threshold",
                "Attack Time",
                "Release Time",
                "Ratio",
                "Knee");
    }

    public void process(AudioFormRequest request) throws IOException {
        AudioWrapper wrapper = request.toEntity();
        processorWrapper proc = wrapper.getProcessorList();

        // 파일 저장
        fileStore.storeFile(request.getInputAudioFile());

        // Audio Buffer 읽기
        jniService.getWavFileReader().loadWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("input.wav"));

        // Compressor 동작
        jniService.process(wrapper.getProcessorType(), wrapper.getAudioBufferFloat(), proc);

        // Output Audio 저장
        jniService.getWavFileReader().saveWavAudioFile(wrapper.getAudioBufferFloat(), fileStore.getFullPath("output.wav"));
    }
}
