package com.robosoft.TwitterJavaEvaluation.controller;

import com.robosoft.TwitterJavaEvaluation.model.*;
import com.robosoft.TwitterJavaEvaluation.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody Users users) {
        if(userService.signUp(users)) {
            return ResponseEntity.status(HttpStatus.OK).body("Registration Successful");
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("User ID Already Taken");
    }
    @GetMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody SignIn signIn) {
        int res = userService.signIn(signIn);
        if(res==0) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong Credentials");
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(String.valueOf(res));
    }
    @GetMapping("/sign-out")
    public ResponseEntity<String> signIn() {
        String res = userService.signOut();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    @PostMapping("/post-profile-photo/{sId}")
    public ResponseEntity<String> addProfilePhoto(@RequestParam("file")MultipartFile file,@PathVariable int sId) {
        if(userService.addProfilePhoto(file, sId)) {
            return ResponseEntity.status(HttpStatus.OK).body("Profile Photo Added.");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied OR Could not save file");
    }
    @GetMapping("/profile-photo")
    public ResponseEntity<Resource> getProfilePhoto() {
        ProfilePhoto profilePhoto = userService.getProfilePhoto();
        if(profilePhoto==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(profilePhoto.getFileType())).header(HttpHeaders.CONTENT_DISPOSITION,"profilePhoto; fileName=\""+profilePhoto.getFileName()+"\"").body(new ByteArrayResource(profilePhoto.getProfilePic()));
    }
    @GetMapping("/my-details/{sId}")
    public ResponseEntity<MyDetails> myDetails(@PathVariable int sId ) {
        MyDetails userDetails = userService.myDetails(sId);
        if(userDetails==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(userDetails);
    }
    @GetMapping("/user-details/{sId}/{userId}")
    public ResponseEntity<UserDetails> myDetails(@PathVariable int sId, @PathVariable String userId) {
        UserDetails userDetails = userService.getUSerDetails(sId,userId);
        if(userDetails==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(userDetails);
    }
    @DeleteMapping("/delete-profile-photo/{sId}")
    public ResponseEntity<String> deleteProfilePhoto(@PathVariable int sId) {
        if(userService.deleteProfilePhoto(sId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Profile Photo Deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Task Denied");
    }
    @PutMapping("/update-profile-photo/{sId}")
    public ResponseEntity<String> updateProfilePhoto(@RequestParam("file")MultipartFile file, @PathVariable int sId) {
        if(userService.updateProfilePhoto(sId, file)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Profile Photo Updated.");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Task Denied");
    }
    @PostMapping("/about/{sId}")
    public ResponseEntity<String> addBio(@PathVariable int sId, @RequestBody String bio) {
        if(userService.addBio(bio, sId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bio added successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Task Denied !");
    }
    @DeleteMapping("/delete-about/{sId}")
    public ResponseEntity<String> deleteBio(@PathVariable int sId) {
        if(userService.deleteBio(sId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bio Deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Task Denied");
    }
    @PutMapping("/update-about/{sId}")
    public ResponseEntity<String> updateAbout(@PathVariable int sId, @RequestBody String bio) {
        if(userService.updateBio(sId,bio)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bio updated successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Task Denied");
    }
}
