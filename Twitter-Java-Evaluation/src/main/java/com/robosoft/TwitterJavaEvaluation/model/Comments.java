package com.robosoft.TwitterJavaEvaluation.model;

import lombok.Data;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class Comments {
    private BigInteger tweetId;
    private BigInteger commentId;
    private String userId;
    private Timestamp dateTime;
    private String content;
    private byte[] attachment;
}
