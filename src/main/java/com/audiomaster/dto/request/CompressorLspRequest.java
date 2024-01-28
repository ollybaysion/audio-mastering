package com.audiomaster.dto.request;

import com.audiomaster.audio.processor.compressorLsp;
import com.audiomaster.dto.AudioContentDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CompressorLspRequest{
    private MultipartFile inputAudioFile = null;
    private double attackThreshold = -20.0;
    private double releaseThreshold = 0.8;
    private double ratio = 2.0;
    private double knee = 6.0;
    private double attackTime = 10;
    private double releaseTime = 140;

    public CompressorLspRequest() {
    }

    public CompressorLspRequest(MultipartFile inputAudioFile, double attackThreshold, double releaseThreshold, double ratio, double knee, double attackTime, double releaseTime) {
        this.inputAudioFile = inputAudioFile;
        this.attackThreshold = attackThreshold;
        this.releaseThreshold = releaseThreshold;
        this.ratio = ratio;
        this.knee = knee;
        this.attackTime = attackTime;
        this.releaseTime = releaseTime;
    }

    public CompressorLspRequest of(MultipartFile inputAudioFile, double attackThreshold, double releaseThreshold, double ratio, double knee, double attackTime, double releaseTime) {
        return new CompressorLspRequest(inputAudioFile, attackThreshold, releaseThreshold, ratio, knee, attackTime, releaseTime);
    }

    public AudioContentDto toDto() {
        return AudioContentDto.of(
                inputAudioFile,
                new compressorLsp((float) attackThreshold, (float) releaseThreshold, (float) attackTime, (float) releaseTime, (float) ratio, (float) knee)
        );
    }
}
