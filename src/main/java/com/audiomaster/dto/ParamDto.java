package com.audiomaster.dto;

import com.audiomaster.dto.request.AudioFormRequest;

import java.util.List;

public class ParamDto {
    List<String> params;

    public ParamDto(List<String> params) {
        this.params = params;
    }

    public static ParamDto of(AudioFormRequest request) {
        return new ParamDto(request.getParams());
    }

    public int getParamInt(int idx) {
        return Integer.parseInt(params.get(idx));
    }

    public float getParamFloat(int idx) {
        return Float.parseFloat(params.get(idx));
    }
}
