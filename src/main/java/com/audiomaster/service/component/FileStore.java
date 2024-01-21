package com.audiomaster.service.component;

import com.audiomaster.dto.AudioContentDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileStore {

    private final String rootPath = System.getProperty("user.home");
    private final String fileDir = rootPath + "\\audio\\";

    public String getFullPath(String filename) { return fileDir + filename; }

    public String storeFile(AudioContentDto audioContentDto) throws IOException {

        MultipartFile multipartFile = audioContentDto.inputAudioFile();

        String inputFilename = getFullPath("input.wav");
        String outputFilename = getOutputFilename(multipartFile.getOriginalFilename());

        if (!new File(inputFilename).exists()) {
            try{
                new File(inputFilename).mkdir();
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }

        multipartFile.transferTo(new File(inputFilename));

        return outputFilename;
    }

    // 확장자 추출
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    private String extractFilename(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(0, pos);
    }

    private String getOutputFilename(String inputFilename) {
        return "output." + extractExt(inputFilename);
    }
}