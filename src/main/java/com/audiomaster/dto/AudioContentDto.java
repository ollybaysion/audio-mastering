package com.audiomaster.dto;
import com.audiomaster.audio.AudioWrapper;
import com.audiomaster.audio.processor.compressor;
import org.springframework.web.multipart.MultipartFile;

public record AudioContentDto(
        MultipartFile inputAudioFile,
        double threshold,
        double ratio,
        double knee,
        double attack,
        double release,
        String outputFilename
){
    public static AudioContentDto of(MultipartFile inputAudioFile, double threshold, double ratio, double knee, double attack, double release) {
        return new AudioContentDto(inputAudioFile, threshold, ratio, knee, attack, release, null);
    }

    public static AudioContentDto of(String outputFilename) {
        return new AudioContentDto(null, 0.0, 0.0, 0.0, 0.0, 0.0, outputFilename);
    }

    public AudioWrapper toEntity() {
        return new AudioWrapper(new compressor(threshold, ratio, knee, attack, release));
    }
}
