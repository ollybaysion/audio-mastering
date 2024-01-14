package com.audiomaster.plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class compressor implements processor {

    private double threshold;
    private double attack_time;
    private double release_time;
    private double ratio;
    private double makeup_gain;


    public compressor(double threshold, double attack_time, double release_time, double ratio, double makeup_gain) {
        this.threshold = threshold;
        this.attack_time = attack_time;
        this.release_time = release_time;
        this.ratio = ratio;
        this.makeup_gain = makeup_gain;
    }

    public static compressor of(double threshold, double attack_time, double release_time, double ratio, double makeup_gain) {
        return new compressor(threshold, attack_time, release_time, ratio, makeup_gain);
    }

    public List<String> toElement() {
        return new ArrayList<>(Arrays.asList(Double.toString(threshold), Double.toString(attack_time), Double.toString(release_time), Double.toString(ratio), Double.toString(makeup_gain)));
    }
}
