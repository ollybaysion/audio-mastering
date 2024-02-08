package com.audiomaster.service;

import com.audiomaster.audio.AudioEntity;
import com.audiomaster.audio.ProcessorType;
import com.audiomaster.dto.request.AudioFormRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AudioMasteringService {

    public List<String> getProcessorList() {
        return Stream.of(ProcessorType.values())
                .map(ProcessorType::getTypeName)
                .collect(Collectors.toList());
    }

    public List<String> getProcessorUrlList() {
        return Stream.of(ProcessorType.values())
                .map(ProcessorType::getTypeUrl)
                .collect(Collectors.toList());
    }

    public AudioFormRequest getRequest(String processorTypeUrl) {
        return AudioFormRequest.of(processorTypeUrl);
    }

    public List<String> getParams(ProcessorType processorType) {
        return processorType.getParamText();
    }

    public void process(AudioFormRequest request) {
        AudioEntity entity = AudioEntity.of(request);
        JniService.process(entity);
        JniService.save(entity.getAudioBuffer(), "output.wav");
    }
}
