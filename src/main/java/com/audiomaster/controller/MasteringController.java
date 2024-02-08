package com.audiomaster.controller;

import com.audiomaster.audio.AudioEntity;
import com.audiomaster.audio.ProcessorType;
import com.audiomaster.dto.request.AudioFormRequest;
import com.audiomaster.service.AudioMasteringService;
import com.audiomaster.service.FileStore;
import com.audiomaster.service.JniService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;

@RequiredArgsConstructor
@RequestMapping("mastering")
@Controller
public class MasteringController {

    private final AudioMasteringService audioMasteringService;

    @GetMapping
    public String mastering(ModelMap map) {
        map.addAttribute("processors", audioMasteringService.getProcessorList());
        map.addAttribute("urls", audioMasteringService.getProcessorUrlList());
        return "mastering/main";
    }

    @GetMapping("form/{processorType}")
    public String formGet(@PathVariable String processorType, ModelMap map) {
        map.addAttribute("request", audioMasteringService.getRequest(processorType));
        map.addAttribute("processorUrl", processorType);
        map.addAttribute("params", audioMasteringService.getParams(ProcessorType.findByTypeUrl(processorType)));
        return "mastering/form";
    }

    @PostMapping("form/{processorType}")
    public String formPost(@ModelAttribute AudioFormRequest request) throws IOException {
        FileStore.saveMultipartfile(request.getInputAudioFile(), "input.wav");
        audioMasteringService.process(request);

        return "mastering/result";
    }

    @ResponseBody
    @GetMapping("/audio/{filename}")
    public Resource getAudio(@PathVariable String filename, ModelMap map) throws MalformedURLException {
        return new UrlResource("file:" + FileStore.getFullPath(filename));
    }
}
