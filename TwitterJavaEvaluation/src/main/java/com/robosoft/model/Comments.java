package com.robosoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
public class Comments {
    private BigInteger tweetId;
    private BigInteger commentId;
    private String userId;
    private Timestamp dateTime;
    private String content;
    private byte[] attachment;
}
