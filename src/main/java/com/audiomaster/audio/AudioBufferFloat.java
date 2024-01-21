package com.audiomaster.audio;

public class AudioBufferFloat {
    private float[][] channels;
    private int numChannels;
    private int numSamples;
    private double sampleRate;
    private int bitsPerSample;

    public AudioBufferFloat() {
    }

    public void setNumChannels(int numChannels) {
        this.numChannels = numChannels;
        channels = new float[numChannels][];
    }

    public void setNumSamples(int numSamples) {
        this.numSamples = numSamples;
        for(int i=0; i<numChannels; i++) {
            channels[i] = new float[numSamples];
        }
    }

    public void setChannel(float[] src, int ch) {
        for(int i=0; i<numSamples; i++) {
            channels[ch][i] = src[i];
        }
    }

    public void setSampleRate(double sampleRate) {
        this.sampleRate = sampleRate;
    }

    public void setBitsPerSample(int bitsPerSample) {
        this.bitsPerSample = bitsPerSample;
    }

    public float[] getChannel(int ch) {
        return channels[ch];
    }

    public double getSampleRate() {
        return sampleRate;
    }

    public int getBitsPerSample() {
        return bitsPerSample;
    }

    public int getNumChannels() {
        return numChannels;
    }

    public int getNumSamples() {
        return numSamples;
    }

    @Override
    public String toString() {
        return "AudioBufferFloat{" +
                "numChannels=" + numChannels +
                ", numSamples=" + numSamples +
                ", sampleRate=" + sampleRate +
                ", bitsPerSample=" + bitsPerSample +
                '}';
    }
}
