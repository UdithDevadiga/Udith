package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class InPatient {
    private int patientId;
    private int stayDuration;
    private int insuranceNumber;
}
