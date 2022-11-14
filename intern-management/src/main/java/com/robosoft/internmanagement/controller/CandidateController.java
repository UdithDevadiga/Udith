package com.robosoft.internmanagement.controller;

<<<<<<< HEAD
import com.robosoft.internmanagement.modelAttributes.CandidateProfile;
import com.robosoft.internmanagement.service.CandidateService;
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
import com.robosoft.internmanagement.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

<<<<<<< HEAD
@RestController
@RequestMapping("/intern-management/candidate")
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
public class CandidateController {

    @Autowired
    private StorageService storageService;

<<<<<<< HEAD
    @Autowired
    private CandidateService candidateService;
=======
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam MultipartFile file, @RequestParam String email, HttpServletRequest request) throws Exception {
        if(storageService.singleFileUpload(file, email, request)) {
            return "Success";
        }
        return "Denied !";
    }
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93


    @GetMapping("/fetch/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        final String filePath = "src\\main\\resources\\static\\documents\\" + fileName;
        Path path = Paths.get(filePath);
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        // Try to determine file's content type
        String contentType = storageService.getContentType(request, resource);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
<<<<<<< HEAD


    @PostMapping("/register")
    public String candidateRegister(@ModelAttribute CandidateProfile candidateProfile, HttpServletRequest request) throws Exception {
        System.out.println(candidateProfile);
        return candidateService.candidateRegister(candidateProfile,request);
    }
=======
>>>>>>> 95d84eb6dcbe051432aae878920020c13c9abc93
}
