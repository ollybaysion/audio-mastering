package com.audiomaster.dto.response;

public record AudioContentResponse(
        String outputFilename
) {

    public static AudioContentResponse of(String outputFilename) {
        return new AudioContentResponse(outputFilename);
    }
    public static AudioContentResponse from(AudioContentDto audioContentDto) {
        return AudioContentResponse.of("output.wav");
    }

}
