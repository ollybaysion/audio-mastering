package com.audiomaster.audio.processor;

import com.audiomaster.audio.processorWrapper;

public class compressorLsp implements processorWrapper {
    private float attackThreshold;
    private float releaseThreshold;
    private float attackTime;
    private float releaseTime;
    private float ratio;
    private float knee;

    public compressorLsp(float attackThreshold, float releaseThreshold, float attackTime, float releaseTime, float ratio, float knee) {
        this.attackThreshold = attackThreshold;
        this.releaseThreshold = releaseThreshold;
        this.attackTime = attackTime;
        this.releaseTime = releaseTime;
        this.ratio = ratio;
        this.knee = knee;
    }

    public compressorLsp of(float attackThreshold, float releaseThreshold, float attackTime, float releaseTime, float ratio, float knee) {
        return new compressorLsp(attackThreshold, releaseThreshold, attackTime, releaseTime, ratio, knee);
    }

    public float getAttackThreshold() {
        return attackThreshold;
    }

    public float getReleaseThreshold() {
        return releaseThreshold;
    }

    public float getAttackTime() {
        return attackTime;
    }

    public float getReleaseTime() {
        return releaseTime;
    }

    public float getRatio() {
        return ratio;
    }

    public float getKnee() {
        return knee;
    }
}
