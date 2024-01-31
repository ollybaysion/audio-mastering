package com.audiomaster.controller;

import com.audiomaster.dto.request.AudioFormRequest;
import com.audiomaster.service.AudioMasteringService;
import com.audiomaster.service.FileStore;
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
    private final FileStore fileStore;

    @GetMapping
    public String mastering(ModelMap map) {
        map.addAttribute("processors", audioMasteringService.getProcessorList());
        return "mastering/main";
    }

    @GetMapping("form/{processorType}")
    public String formGet(@PathVariable String processorType, ModelMap map) {
        map.addAttribute("request", audioMasteringService.getRequest(processorType));
        map.addAttribute("processorType", processorType);
        map.addAttribute("params", audioMasteringService.getParams(processorType));
        return "mastering/form";
    }

    @PostMapping("form/{processorType}")
    public String formPost(@PathVariable String processorType, @ModelAttribute AudioFormRequest request, ModelMap map) throws IOException {
        audioMasteringService.process(request);
        return "mastering/form";
    }

    @ResponseBody
    @GetMapping("/audio/{filename}")
    public Resource getAudio(@PathVariable String filename, ModelMap map) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }
}
