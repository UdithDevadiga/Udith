package com.robosoft.TwitterJavaEvaluation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
@Data
public class Tweets {
    private BigInteger tweetId;
    private String userId;
    private Timestamp dateTime;
    private String content;
    private byte[] attachment;
}
