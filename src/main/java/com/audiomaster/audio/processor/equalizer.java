package com.audiomaster.audio.processor;

import com.audiomaster.audio.type.EqType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class equalizer implements processor {
    private EqType bandType;
    private double gain;
    private double freq;
    private double q_value;

    public equalizer(EqType bandType, double gain, double freq, double q_value) {
        this.bandType = bandType;
        this.gain = gain;
        this.freq = freq;
        this.q_value = q_value;
    }

    public static equalizer of(EqType bandType, double gain, double freq, double q_value) {
        return new equalizer(bandType, gain, freq, q_value);
    }

    public List<String> toElement() {
        return new ArrayList<>(Arrays.asList(bandType.toString(), Double.toString(gain), Double.toString(freq), Double.toString(q_value)));
    }
}
