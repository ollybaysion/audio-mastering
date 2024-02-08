package com.audiomaster.service.jni;

import com.audiomaster.audio.AudioBuffer;
import com.audiomaster.dto.ParamDto;
import org.springframework.stereotype.Service;

@Service
public class AudioLibrary {
    static {
        System.loadLibrary("AudioLibrary");
    }

    public AudioLibrary() {
    }

    public native void processAndLoad(int type, AudioBuffer buffer, ParamDto param);
}
