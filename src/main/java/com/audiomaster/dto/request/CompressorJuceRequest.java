package com.audiomaster.dto.request;

import com.audiomaster.audio.processor.compressorJuce;
import com.audiomaster.dto.AudioContentDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CompressorJuceRequest{
    private MultipartFile inputAudioFile = null;
    private double threshold = -20.0;
    private double ratio = 2.0;
    private double knee = 6.0;
    private double attack = 0.01;
    private double release = 0.14;

    public CompressorJuceRequest() {
    }

    public CompressorJuceRequest(MultipartFile inputAudioFile, double threshold, double ratio, double knee, double attack, double release) {
        this.inputAudioFile = inputAudioFile;
        this.threshold = threshold;
        this.ratio = ratio;
        this.knee = knee;
        this.attack = attack;
        this.release = release;
    }

    public static CompressorJuceRequest of(MultipartFile inputAudioFile, double threshold, double ratio, double knee, double attack, double release) {
        return new CompressorJuceRequest(inputAudioFile, threshold, ratio, knee, attack, release);
    }

    public AudioContentDto toDto() {
        return AudioContentDto.of(
                inputAudioFile,
                new compressorJuce(threshold, ratio, knee, attack, release)
        );
    }
}
