package com.robosoft.internmanagement.service;

<<<<<<< HEAD
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.channels.MulticastChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private static final String UPLOADED_FOLDER = "src\\main\\resources\\static\\documents\\";

    private final Path root = Paths.get("src\\main\\resources\\static\\documents\\");

<<<<<<< HEAD
    public String singleFileUpload(MultipartFile file, String email, HttpServletRequest request) {
        String fileUrl = null;
        if (file.isEmpty()) {
            return "file is empty";
        }

        try {
            File newDirectory = new File(UPLOADED_FOLDER, email);
            if(!(newDirectory.exists())){
                newDirectory.mkdir();
            }
            String CREATED_FOLDER = UPLOADED_FOLDER + email + "\\";
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(CREATED_FOLDER  + file.getOriginalFilename());
=======
    public Boolean singleFileUpload(MultipartFile file, String email, HttpServletRequest request) throws Exception {

        if (file.isEmpty()) {
            return false;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + email + file.getOriginalFilename());
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
            Resource resource = new UrlResource(path.toUri());
            String contentType = getContentType(request, resource);
            System.out.println(path);
            Files.write(path, bytes);
<<<<<<< HEAD
            fileUrl = generateDocumentUrl(email + "/" + file.getOriginalFilename());
            System.out.println(fileUrl);
            

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileUrl;
=======
            generateDocumentUrl(email + file.getOriginalFilename());
            System.out.println(generateDocumentUrl(email + file.getOriginalFilename()));
            

        } catch (IOException e) {
            throw new Exception();
        }

        return true;
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
    }

    public String generateDocumentUrl(String fileName){
        final String apiUrl = "http://localhost:8080/intern-management/fetch/";
        return apiUrl + fileName;
    }

<<<<<<< HEAD
    public Resource load(String filename) {

        System.out.println("src\\main\\resources\\static\\documents\\".length());
        //String file;
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
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93

    public String getContentType(HttpServletRequest request, Resource resource){
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            System.out.println(contentType);
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return contentType;
    }

}
