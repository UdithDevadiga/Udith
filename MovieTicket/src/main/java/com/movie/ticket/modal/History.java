package com.movie.ticket.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    private int id;
    private String fname;
    private String lname;
    private String title;
    private String name;
    private int seats;
}
