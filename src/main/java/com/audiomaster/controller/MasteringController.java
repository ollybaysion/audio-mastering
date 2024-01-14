package com.audiomaster.controller;

import com.audiomaster.service.AudioMasteringService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("mastering")
@Controller
public class MasteringController {

    private final AudioMasteringService audioMasteringService;

    @GetMapping
    public String mastering(ModelMap map) {
        map.addAttribute("matsering", List.of());
        return "mastering/main";
    }

    @GetMapping("upload")
    public String uploadMastering(ModelMap map) {
        return "redirect:/mastering";
    }

    @PostMapping("upload")
    public String uploadMasteringFile(MultipartFile[] AudioInputFile, ModelMap map) {
        audioMasteringService.saveAudioFile(AudioInputFile);
        return "redirect:/mastering";
    }
}
