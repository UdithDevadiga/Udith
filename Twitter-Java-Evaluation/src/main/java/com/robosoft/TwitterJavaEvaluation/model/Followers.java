package com.robosoft.TwitterJavaEvaluation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Followers {
    private String userId;
    private String followerId;
}
