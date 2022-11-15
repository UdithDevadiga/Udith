package com.robosoft.internmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TopTechnologies {
    private String designation;
    private List<String> location;

}
