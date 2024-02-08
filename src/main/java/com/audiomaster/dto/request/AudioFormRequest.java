package com.audiomaster.dto.request;

import com.audiomaster.audio.AudioEntity;
import com.audiomaster.audio.ProcessorType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AudioFormRequest {
    private MultipartFile inputAudioFile = null;
    private List<String> params;
    private String processorType;

    public AudioFormRequest(String processorType) {
        this.processorType = processorType;
        params = new ArrayList<>(ProcessorType.findByTypeUrl(processorType).getParamText().size());
    }

    public static AudioFormRequest of(String processorType) {
        return new AudioFormRequest(processorType);
    }
}
