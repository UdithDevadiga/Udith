package com.robosoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Followers {
    private String userId;
    private String followerId;
}
