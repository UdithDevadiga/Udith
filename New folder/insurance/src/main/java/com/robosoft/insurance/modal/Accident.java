package com.robosoft.insurance.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accident {
    private int reportNumber;
    private Date accd_date;
    private String location;
}
