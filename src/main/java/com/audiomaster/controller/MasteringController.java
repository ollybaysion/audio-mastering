package com.audiomaster.controller;

import com.audiomaster.domain.constant.AudioProcessStatus;
import com.audiomaster.dto.AudioContentDto;
import com.audiomaster.dto.request.AudioContentRequest;
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

    @GetMapping("compressor")
    public String compressor(ModelMap map) {
        map.addAttribute("inputAudioContent", new AudioContentRequest());
        return "mastering/form";
    }

    @PostMapping("compressor")
    public String uploadMasteringFile(@ModelAttribute AudioContentRequest inputAudioContent, ModelMap map) throws IOException {
        AudioContentDto audioContentDto = audioMasteringService.processCompressor(inputAudioContent.toDto());

        map.addAttribute("inputAudioContent", inputAudioContent);
        map.addAttribute("AudioProcessStatus", AudioProcessStatus.OK);
        map.addAttribute("outputAudioContent", AudioContentResponse.from(audioContentDto));
        return "mastering/form";
    }

    @ResponseBody
    @GetMapping("/audio/{filename}")
    public Resource getAudio(@PathVariable String filename, ModelMap map) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }
}
