package com.evaluation2.patientmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class HelpDesk {
    private int id;
    private String floor;
    private int hospitalId;
}
