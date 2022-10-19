package com.movie.ticket.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String fName;
    private String lName;
    private long phNumber;
    private  String location;
    private String email;
}
