package com.audiomaster.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStore {

    private static final String rootPath = System.getProperty("user.home");
    private static final String fileDir = rootPath + "/audio/";

    public static String getFullPath(String filename) { return fileDir + filename; }

    public static void saveMultipartfile(MultipartFile multipartFile, String fileName) throws IOException {
        String inputFilename = getFullPath(fileName);
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
    }

    // 확장자 추출
    private static String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    private String extractFilename(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(0, pos);
    }

    private static String getOutputFilename(String inputFilename) {
        return "output." + extractExt(inputFilename);
    }
}