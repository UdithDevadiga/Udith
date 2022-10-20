package com.robosoft.TwitterJavaEvaluation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
@Data
public class Tags {
    private String tagName;
    private BigInteger tweetId;
}
