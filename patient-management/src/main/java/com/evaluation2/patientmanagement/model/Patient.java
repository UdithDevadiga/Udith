package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private long phoneNumber;
    private String type;
}
