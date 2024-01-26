package com.audiomaster.dto;
import com.audiomaster.audio.AudioWrapper;
import com.audiomaster.audio.processorWrapper;
import org.springframework.web.multipart.MultipartFile;

public record AudioContentDto(
        MultipartFile inputAudioFile,
        processorWrapper proc,
        String outputFilename
){
    public static AudioContentDto of(MultipartFile inputAudioFile, processorWrapper proc) {
        return new AudioContentDto(inputAudioFile, proc, null);
    }

    public static AudioContentDto of(String outputFilename) {
        return new AudioContentDto(null, null, outputFilename);
    }

    public AudioWrapper toEntity() {
        return new AudioWrapper(proc);
    }
}
