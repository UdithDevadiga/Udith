package com.movie.ticket.service;

import com.movie.ticket.modal.Admin;
import com.movie.ticket.modal.Movies;
import com.movie.ticket.modal.Shows;
import com.movie.ticket.modal.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String adminRegister(Admin admin) {
        String query = "insert into admin values("+admin.getId()+",'"+admin.getPassword()+"')";
        int status = jdbcTemplate.update(query);
        return "Registration is Done";
    }

    public boolean adminAuthentication(String password) {
        try {
            String query = "select password from admin where password =  '"+password+"'";
            jdbcTemplate.queryForObject(query, String.class);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String addMovies(Movies movies,String password) {
        if(adminAuthentication(password)) {
            String query = "insert into movies values(" + movies.getId() + ",'" + movies.getTitle() + "','" + movies.getDescription() + "','" + movies.getTiming() + "')";
            int status = jdbcTemplate.update(query);
            return "Movies added successfully.";
        }
        return "Access Denied !";
    }

    public String addTheatre(Theatre theatre,String password) {
        if(adminAuthentication(password)) {
            String query = "insert into theatre values(" + theatre.getId() + ",'" + theatre.getName() + "','" + theatre.getLocation() + "'," + theatre.getCost() + ")";
            int status = jdbcTemplate.update(query);
            return "Theatre added successfully.";
        }
        return "AccessDenied !";
    }

    public String addShows(Shows shows,String password) {
        if(adminAuthentication(password)) {
            String query = "insert into shows values(" + shows.getId() + "," + shows.getTheatre_id() + "," + shows.getMovie_id() + "," + shows.getSeats() + "," + shows.getScreen_no() + ",'" + shows.getDay() + "','" + shows.getStart_time() + "','" + shows.getEnd_time() + "')";
            jdbcTemplate.update(query);
            return "Shows added successfully.";
        }
        return "Access Denied !";
    }

    public List viewTheatresByMovieId(int movie_id,String password) {
        List<String> theatre=null;
        if(adminAuthentication(password)) {
            String query = "select theatre.id,theatre.name,theatre.location,theatre.cost from shows inner join theatre on shows.theatre_id=theatre.id where movie_id =" + movie_id;
            List<Theatre> theatreList= jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Theatre.class));
            return theatreList;
        }
        theatre.add("Access Denied !");
        return theatre;
    }

    public String updateMovie(Movies movie,String password) {
        if(adminAuthentication(password)) {
            String query = "update movies set title = '" + movie.getTitle() + "', description = '" + movie.getDescription() + "', timing = '" + movie.getTiming() + "' where id =" + movie.getId();
            jdbcTemplate.update(query);
            return "Updated Successfully";
        }
        return "Access Denied !";
    }
}
