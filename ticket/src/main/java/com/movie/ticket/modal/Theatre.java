package com.movie.ticket.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
    private int id;
    private String name;
    private String location;
    private double cost;
}
