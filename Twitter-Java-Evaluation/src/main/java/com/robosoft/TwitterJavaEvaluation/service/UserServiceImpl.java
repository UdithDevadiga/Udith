package com.robosoft.TwitterJavaEvaluation.service;

import com.robosoft.TwitterJavaEvaluation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    JdbcTemplate jdbcTemplate;

    private int sessionId;
    private String userID;

    @Override
    public Boolean userAuthentication(int sId) {
        if(sId==sessionId) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean signUp(Users users) {
        try {
            String checkQuery = "select user_id from users where user_id = '" + users.getUserId() + "'";
            String userId = jdbcTemplate.queryForObject(checkQuery, new BeanPropertyRowMapper<>(String.class));
        } catch (Exception e) {
            String query = "insert into users(user_id,user_name,email,password,phone_number,date_of_birth) values('"+users.getUserId()+"','"+users.getUserName()+"','"+users.getEmail()+"','"+users.getPassword()+"',"+users.getPhoneNumber()+",'"+users.getDateOfBirth()+"')";
            jdbcTemplate.update(query);
            return true;
        }
        return false;
    }

    @Override
    public int signIn(SignIn signIn) {
        userID = signIn.getUserId();
        try {
            String query = "Select user_id from users where user_id = '" + signIn.getUserId() + "' and password = '" + signIn.getPassword()+ "'";
            String userId = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(String.class));
            sessionId = new Random().nextInt(1,100000);
            return sessionId;
        } catch (Exception e) {
            return 0;
        }
    }

    public String signOut() {
        sessionId=0;
        return "Sign Out Successful";
    }

    @Override
    public Boolean addProfilePhoto(MultipartFile file,int sId) {
        if (userAuthentication(sId)) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String downloadURL = "";
            try {
                if (fileName.contains("..")) {
                    throw new Exception("File Name Contains Invalid Sequence " + fileName);
                }
                downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/profile-photo").toUriString();
                String query = "insert into profile_photo values(?,?,?,?,?)";
                String finalDownloadURL = downloadURL;
                jdbcTemplate.update(query, (preparedStatement) -> {
                    preparedStatement.setString(1, userID);
                    preparedStatement.setString(2, fileName);
                    preparedStatement.setString(3, file.getContentType());
                    try {
                        preparedStatement.setBinaryStream(4, new ByteArrayInputStream(file.getBytes()), file.getBytes().length);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    preparedStatement.setString(5, finalDownloadURL);
                });
                return true;
            } catch (Exception e) {
                System.out.println("Could not save file " + fileName);
                return false;
            }
        }
        return false;
    }

    @Override
    public Boolean deleteProfilePhoto(int sId) {
        if(userAuthentication(sId)) {
            try {
                String query = "delete from profile_photo where user_id = '" + userID + "'";
                jdbcTemplate.update(query);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Boolean updateProfilePhoto(int sId, MultipartFile file) {
        try {
            deleteProfilePhoto(sId);
            addProfilePhoto(file, sId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ProfilePhoto getProfilePhoto() {
            String query = "select user_id,file_name,file_type,profile_pic from profile_photo where user_id = '" + userID + "'";
            List<ProfilePhoto> profilePhotos = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ProfilePhoto.class));
            int size = profilePhotos.size();
            if (size == 0) {
                return null;
            }
            return profilePhotos.get(0);
        }


    @Override
    public MyDetails myDetails(int sId) {
        if(userAuthentication(sId)) {
            String query = "select users.user_id,users.user_name,users.email,users.phone_number,users.date_of_birth,profile_photo.download_url,users.followers,users.following,users.about,users.verified from users inner join profile_photo using(user_id) where users.user_id='"+userID+"'";
            List<MyDetails> myDetails = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(MyDetails.class));
            int size = myDetails.size();
            if (size == 0) {
                return null;
            }
            return myDetails.get(0);
        }
        return null;
    }

    @Override
    public UserDetails getUSerDetails(int sId, String userId) {
        if(userAuthentication(sId)) {
            String query = "select users.user_id,users.user_name,users.date_of_birth,profile_photo.download_url,users.followers,users.following,users.about,users.verified from users inner join profile_photo using(user_id) where users.user_id='"+userId+"'";
            List<UserDetails> userDetails = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(UserDetails.class));
            int size = userDetails.size();
            if (size == 0) {
                return null;
            }
            return userDetails.get(0);
        }
        return null;
    }

    @Override
    public Boolean addBio(String bio,int sId) {
        if(userAuthentication(sId)) {
            try {
                String query = "update users set about='"+bio+"' where user_id='"+userID+"'";
                jdbcTemplate.update(query);
                System.out.println("Im");
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Boolean deleteBio(int sId) {
        if(userAuthentication(sId)) {
            try {
                String query = "update users set about = '' where user_id='"+userID+"'";
                jdbcTemplate.update(query);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Boolean follow(int sId, String userId) {
        if(userAuthentication(sId)) {
           String checkQuery = "select user_id from users where user_id = '"+userId+"'";
           List<String> userIds = jdbcTemplate.queryForList(checkQuery, String.class);
           int size = userIds.size();
           if(size!=0) {
               String query = "insert into followers values('"+userID+"','"+userId+"')";
               jdbcTemplate.update(query);
               String selQuery = "select following from users where user_id = '"+userID+"'";
               int count = jdbcTemplate.queryForObject(selQuery, Integer.class);
               count=count+1;
               String seleQuery = "select followers from users where user_id = '"+userId+"'";
               int followCount = jdbcTemplate.queryForObject(seleQuery, Integer.class);
               followCount=followCount+1;
               String updateQuery = "update users set following = "+count+" where user_id = '"+userID+"'";
               jdbcTemplate.update(updateQuery);
               String updateFollowQuery = "update users set followers = "+followCount+" where user_id = '"+userId+"'";
               jdbcTemplate.update(updateFollowQuery);
               return true;
           }
           return false;
        }
        return false;
    }

    @Override
    public Boolean addTweetDetails(TweetDetail tweetDetail) {
        return null;
    }

}
