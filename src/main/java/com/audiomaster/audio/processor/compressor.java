package com.audiomaster.audio.processor;

public class compressor implements processor {

    private double threshold;
    private double ratio;
    private double knee;
    private double attack;
    private double release;

    public compressor(double threshold, double ratio, double knee, double attack, double release) {
        this.threshold = threshold;
        this.ratio = ratio;
        this.knee = knee;
        this.attack = attack;
        this.release = release;
    }

    public static compressor of(double threshold, double ratio, double knee, double attack, double release) {
        return new compressor(threshold, ratio, knee, attack, release);
    }
}
