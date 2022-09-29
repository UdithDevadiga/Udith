package com.movie.ticket.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shows {
    private int id;
    private int theatre_id;
    private int movie_id;
    private int seats;
    private int screen_no;
    private Date day;
    private Time start_time;
    private Time end_time;
}
