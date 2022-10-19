package com.robosoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
@Setter
@Getter
@AllArgsConstructor
public class Likes {
    private String userId;
    private BigInteger tweetId;
}
