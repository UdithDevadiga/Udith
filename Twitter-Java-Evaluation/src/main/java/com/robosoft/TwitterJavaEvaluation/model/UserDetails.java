package com.robosoft.TwitterJavaEvaluation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Data
public class UserDetails {
    private String userId;
    private String userName;
    private Date dateOfBirth;
    private String downloadUrl;
    private long followers;
    private long following;
    private String about;
    private Boolean verified;
}
