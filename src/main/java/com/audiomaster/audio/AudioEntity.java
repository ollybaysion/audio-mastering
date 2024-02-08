package com.audiomaster.audio;

import com.audiomaster.dto.ParamDto;
import com.audiomaster.dto.request.AudioFormRequest;
import com.audiomaster.service.FileStore;
import com.audiomaster.service.JniService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class AudioEntity {
    private AudioBuffer audioBuffer;
    private ProcessorType processorType;
    private ParamDto paramDto;

    public AudioEntity(ProcessorType processorType, ParamDto paramDto, String fileName) {
        audioBuffer = new AudioBuffer();
        this.processorType = processorType;
        this.paramDto = paramDto;
        JniService.load(audioBuffer, fileName);
    }

    public static AudioEntity of(AudioFormRequest request) {
        return new AudioEntity(ProcessorType.findByTypeUrl(request.getProcessorType()), ParamDto.of(request), FileStore.getFullPath("input.wav"));
    }


}
