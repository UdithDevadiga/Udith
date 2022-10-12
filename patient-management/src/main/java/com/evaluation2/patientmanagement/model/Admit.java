package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@AllArgsConstructor
public class Admit {
    private int admitId;
    private int patientId;
    private int wardNumber;
    private Date admitDate;
}
