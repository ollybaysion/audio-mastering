package com.audiomaster.audio.processor;

import com.audiomaster.audio.processorWrapper;

public class compressorJuce implements processorWrapper {

    private double threshold;
    private double ratio;
    private double knee;
    private double attack;
    private double release;

    public compressorJuce(double threshold, double ratio, double knee, double attack, double release) {
        this.threshold = threshold;
        this.ratio = ratio;
        this.knee = knee;
        this.attack = attack;
        this.release = release;
    }

    public static compressorJuce of(double threshold, double ratio, double knee, double attack, double release) {
        return new compressorJuce(threshold, ratio, knee, attack, release);
    }
}
