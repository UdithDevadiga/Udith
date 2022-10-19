package com.robosoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@AllArgsConstructor
public class Users {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private long phoneNumber;
    private Date dateOfBirth;
    private byte[] profilePhoto;
    private long followers;
    private long following;
    private String about;
    private Boolean verified;
}
