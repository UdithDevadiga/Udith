package com.robosoft.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadController {
    private static final String DIR_TO_UPLOAD = "C:\\Users\\Udith Devadiga\\FileUploadSaves";

    @PostMapping("/directory")
    public String uploadToDirectory(@RequestParam MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(DIR_TO_UPLOAD + file.getOriginalFilename());
        Files.write(path,bytes);
        return "File Uploaded Successfully";
    }
}
