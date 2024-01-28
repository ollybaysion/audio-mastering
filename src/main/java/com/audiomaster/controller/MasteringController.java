package com.audiomaster.controller;

import com.audiomaster.domain.constant.AudioProcessStatus;
import com.audiomaster.dto.AudioContentDto;
import com.audiomaster.dto.request.CompressorJuceRequest;
import com.audiomaster.dto.request.CompressorLspRequest;
import com.audiomaster.dto.response.AudioContentResponse;
import com.audiomaster.service.AudioMasteringService;
import com.audiomaster.service.component.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("mastering")
@Controller
public class MasteringController {

    private final AudioMasteringService audioMasteringService;
    private final FileStore fileStore;

    @GetMapping
    public String mastering(ModelMap map) {
        map.addAttribute("matsering", List.of());
        return "mastering/main";
    }

    @GetMapping("compressor1")
    public String compressor1(ModelMap map) {
        map.addAttribute("inputAudioContent", new CompressorJuceRequest());
        return "mastering/compressorJUCE";
    }

    @PostMapping("compressor1")
    public String uploadMasteringFile1(@ModelAttribute CompressorJuceRequest inputAudioContent, ModelMap map) throws IOException {
        AudioContentDto audioContentDto = audioMasteringService.processCompressorJuce(inputAudioContent.toDto());

        map.addAttribute("inputAudioContent", inputAudioContent);
        map.addAttribute("AudioProcessStatus", AudioProcessStatus.OK);
        map.addAttribute("outputAudioContent", AudioContentResponse.from(audioContentDto));
        return "mastering/compressorJUCE";
    }

    @GetMapping("compressor2")
    public String compressor2(ModelMap map) {
        map.addAttribute("inputAudioContent", new CompressorLspRequest());
        return "mastering/compressorLSP";
    }

    @PostMapping("compressor2")
    public String uploadMasteringFile2(@ModelAttribute CompressorLspRequest inputAudioContent, ModelMap map) throws IOException {
        AudioContentDto audioContentDto = audioMasteringService.processCompressorLsp(inputAudioContent.toDto());

        map.addAttribute("inputAudioContent", inputAudioContent);
        map.addAttribute("AudioProcessStatus", AudioProcessStatus.OK);
        map.addAttribute("outputAudioContent", AudioContentResponse.from(audioContentDto));
        return "mastering/compressorLSP";
    }

    @ResponseBody
    @GetMapping("/audio/{filename}")
    public Resource getAudio(@PathVariable String filename, ModelMap map) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }
}
