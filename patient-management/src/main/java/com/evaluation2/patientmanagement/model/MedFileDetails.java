package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MedFileDetails {
    private int medicalFileId;
    private int medicalRecordId;
    private int patientId;
    private String patientName;
    private int doctorId;
    private String doctorName;
    private String status;
}
