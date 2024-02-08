package com.audiomaster.service;

import com.audiomaster.audio.AudioBuffer;
import com.audiomaster.audio.AudioEntity;
import com.audiomaster.service.jni.AudioLibrary;
import com.audiomaster.service.jni.WavFileReader;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class JniService {
    private static WavFileReader wavFileReader;
    private static AudioLibrary audioLibrary;

    public JniService(WavFileReader wavFileReader, AudioLibrary audioLibrary) {
        JniService.wavFileReader = wavFileReader;
        JniService.audioLibrary = audioLibrary;
    }

    public static void load(AudioBuffer buffer, String fileName) {
        wavFileReader.loadWavAudioFile(buffer, fileName);
    }

    public static void save(AudioBuffer buffer, String fileName) {
        wavFileReader.saveWavAudioFile(buffer, FileStore.getFullPath(fileName));
    }
    public static void process(AudioEntity entity) {
        audioLibrary.processAndLoad(entity.getProcessorType().getTypeId(), entity.getAudioBuffer(), entity.getParamDto());
    }
}
