package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DoctorLocation {
    private int doctorId;
    private String doctorName;
    private int departmentId;
    private String departmentName;
    private String floor;
}
