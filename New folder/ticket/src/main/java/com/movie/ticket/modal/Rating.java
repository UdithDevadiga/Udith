package com.movie.ticket.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private int cust_id;
    private int movie_id;
    private int rating;
    private String feedback;
}
