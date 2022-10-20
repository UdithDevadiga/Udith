package com.robosoft.TwitterJavaEvaluation.service;


import com.robosoft.TwitterJavaEvaluation.model.*;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
     Boolean userAuthentication(int sId);
     Boolean signUp(Users users);
     int signIn(SignIn signIn);
     String signOut();
     Boolean addProfilePhoto(MultipartFile file, int sId);
     Boolean deleteProfilePhoto(int sId);
     Boolean updateProfilePhoto(int sId, MultipartFile file);
     ProfilePhoto getProfilePhoto();
     MyDetails myDetails(int sId);
     UserDetails getUSerDetails(int sId, String userId);
     Boolean addBio(String bio, int sId);
     Boolean deleteBio(int sId);
     Boolean follow(int sId, String userId);
     Boolean addTweetDetails(TweetDetail tweetDetail);
}

