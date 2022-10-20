package com.robosoft.TwitterJavaEvaluation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
@Data
public class Likes {
    private String userId;
    private BigInteger tweetId;
}
