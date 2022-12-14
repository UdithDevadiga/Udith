package com.robosoft.internmanagement.service;

import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private static final String UPLOADED_FOLDER = "src\\main\\resources\\static\\documents\\";

    private final Path root = Paths.get("src\\main\\resources\\static\\documents\\");

    public String singleFileUpload(MultipartFile file, String email, HttpServletRequest request) throws Exception {
        String fileUrl = null;
        if (file.isEmpty()) {
            throw new Exception("File is empty");
        }

        try {
            File newDirectory = new File(UPLOADED_FOLDER, email);
            if(!(newDirectory.exists())){
                newDirectory.mkdir();
            }
            String CREATED_FOLDER = UPLOADED_FOLDER + email + "\\";
            byte[] bytes = file.getBytes();
            Path path = Paths.get(CREATED_FOLDER  + file.getOriginalFilename());
            System.out.println(path);
            Files.write(path, bytes);
            fileUrl = generateDocumentUrl(email + "/" + file.getOriginalFilename());
            System.out.println(fileUrl);

        } catch (IOException i) {
            throw new Exception("Errors while uploading file");
        }

        return fileUrl;
    }

    public String generateDocumentUrl(String fileName){
        final String apiUrl = "http://localhost:8080/intern-management/member/fetch/";
        return apiUrl + fileName;
    }

    public Resource load(String filename) {

        System.out.println("src\\main\\resources\\static\\documents\\".length());
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public String getContentType(HttpServletRequest request, Resource resource){
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            System.out.println(contentType);
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return contentType;
    }

}
