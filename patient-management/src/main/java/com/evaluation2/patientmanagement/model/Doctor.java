package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Doctor {
    private int id;
    private String name;
    private int age;
    private String gender;
    private int deptId;
    private int maxPatient;
}
