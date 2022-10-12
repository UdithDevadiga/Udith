package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MedicalRecord {
    private int id;
    private int patientId;
    private int doctorId;
    private String report;
    private int medicalFileId;
}
