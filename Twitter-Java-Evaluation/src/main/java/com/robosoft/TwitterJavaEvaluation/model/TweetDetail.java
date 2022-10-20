package com.robosoft.TwitterJavaEvaluation.model;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class TweetDetail {
    private BigInteger tweetId;
    private String userId;
    private String hashtags;
    private String content;
}
