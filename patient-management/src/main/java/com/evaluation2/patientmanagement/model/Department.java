package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
public class Department {
    private int id;
    private String name;
    private String floor;
}
