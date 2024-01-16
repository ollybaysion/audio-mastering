package com.audiomaster.controller;

import com.audiomaster.service.AudioMasteringService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    @GetMapping("compressor")
    public String compressor(ModelMap map) {
        map.addAttribute("compressor", List.of());
        return "mastering/form";
    }

    @GetMapping("process")
    public String uploadMastering(ModelMap map) {
        return "redirect:/mastering";
    }

    @PostMapping("process")
    public String uploadMasteringFile(MultipartFile AudioInputFile, ModelMap map) {
        try {
            String origFilename = AudioInputFile.getOriginalFilename();
            String filename = origFilename;    // TODO - MD5를 통한 Encryption
            String savePath = System.getProperty("user.home") + "\\audio";

            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }

            String filePath = savePath + "\\" + filename;
            AudioInputFile.transferTo(new File(filePath));
        } catch(Exception e) {
            e.printStackTrace();
        }

        map.addAttribute("outputFile", 0);
        return "redirect:/mastering";
    }
}
