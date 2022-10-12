package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@AllArgsConstructor
public class Insurance {
    private String insuranceNumber;
    private Date expiryDate;
}
