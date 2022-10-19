package com.movie.ticket.service;


import com.movie.ticket.modal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Random;

@Service
public class CustomerService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private int sessionId;
    private int customerId;
    public String register(Customer customer) {
        String query = "insert into customer values("+customer.getId()+",'"+customer.getFName()+"','"+customer.getLName()+"','"+customer.getPhNumber()+"','"+customer.getLocation()+"','"+customer.getEmail()+"')";
        jdbcTemplate.update(query);
        return "Registration is Done";
    }

    public int logIn(int id, long phNumber) {
        customerId = id;
        try {
            String query = "Select * from customer where id =" + id + " and phNumber = " + phNumber;
            jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Customer.class));
            sessionId = new Random().nextInt(1, 1000);
            return sessionId;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Boolean customerAuthentication(int sId) {
        if(sId==sessionId) {
            return true;
        }
        return false;
    }

    public Customer viewDetails(int sID) {
        if(customerAuthentication(sID)) {
            String query = "select * from customer where id =" + customerId;
            List<Customer> customerList= jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Customer.class));
            return customerList.get(0);
        }
        return null;
    }

    public List<Movies> viewMoviesByName(int sID, String movieName) {
        if(customerAuthentication(sID)) {
            String query = "select * from movies where title = '"+movieName+"'";
            return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Movies.class));
        }
        return null;
    }

    public List<Movies> viewMovies(int sID) {
        if(customerAuthentication(sID)) {
            String query = "select * from movies";
            return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Movies.class));
        }
        return null;
    }

    public List<Shows> viewShows(int sID) {
        if(customerAuthentication(sID)) {
            String query = "select * from shows";
            return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Shows.class));
        }
        return null;
    }

    public int getAvailableSeats(int sId, int show_id) {
        if(customerAuthentication(sId)) {
            String query = "Select seats from shows where id = " + show_id;
            return jdbcTemplate.queryForObject(query, Integer.class);
        }
        return -1;
    }

    public String book(int sId, Booking booking) {
        if(customerAuthentication(sId)) {
            int availableSeats = getAvailableSeats(sId,booking.getShow_id());
            if(checkSeats(sId,booking.getShow_id(), booking.getSeats())) {
                if (booking.getCust_id() == customerId){
                    String query = "insert into booking values(" + booking.getShow_id() + "," + booking.getCust_id() + "," + booking.getSeats() + ")";
                    jdbcTemplate.update(query);
                    int remainingSeats = availableSeats - booking.getSeats();
                    String upQuery = "update shows set seats = " + remainingSeats + " where id = " + booking.getShow_id();
                    jdbcTemplate.update(upQuery);
                    return "Successfully booked " + booking.getSeats() + " seats";
                }
                return "Wrong customer ID ! Please provide valid credentials";
            }
            return "Denied ! Available seats are "+availableSeats;
        }
        return "Access Denied !";
    }

    public boolean checkSeats(int sId, int showId, int seats) {
       int availableSeats = getAvailableSeats(sId,showId);
       if(seats>availableSeats) {
           return false;
       }
       return true;
    }

    public List<Booking> viewHistory(int sId) {
        if(customerAuthentication(sId)) {
            String query = "select * from booking where cust_id = " + customerId;
            return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Booking.class));
        }
        return null;
    }

    public List<Theatre> viewTheatresNearMe(int sId) {
        if (customerAuthentication(sId)) {
            String query = "select location from customer where id = '"+customerId+"'";
            String location = jdbcTemplate.queryForObject(query,String.class);
            String theatreQuery = "Select * from theatre where location = '"+location+"'";
            System.out.println("boba"+theatreQuery);
            return jdbcTemplate.query(theatreQuery,new BeanPropertyRowMapper<>(Theatre.class));
        }
        return null;
    }

    public List<Theatre> viewTheatresByLocation(int sId, String location) {
        if (customerAuthentication(sId)) {
            System.out.println("yoyo"+location);
            String query = "Select * from theatre where location = '"+location+"'";
            System.out.println(query);
            List<Theatre> list = jdbcTemplate.query(query,(resultSet,no)->{
                Theatre t = new Theatre();
                t.setId(resultSet.getInt(1));
                t.setName(resultSet.getString(2));
                t.setLocation(resultSet.getString(3));
                t.setCost(resultSet.getDouble(4));
                return t;
            });
            System.out.println(list);
            return list;
        }
        return null;
    }

    public String giveRatings(int sId, Rating rating) {
        if(customerAuthentication(sId)) {
            if(rating.getRating()<5 && rating.getRating()>-1) {
                String query = "insert into rating values(" + customerId + "," + rating.getMovie_id() + "," + rating.getRating() + ",'" + rating.getFeedback() + "')";
                jdbcTemplate.update(query);
                return "Ratings submitted successfully :) Thank you for the feedback";
            }
            return "Please enter a valid rating (You can rate the film from 0 to 5)";
        }
        return "Access Denied !";
    }

    public double getAvgRating(int sId, String title) {
        if(customerAuthentication(sId)) {
            String query = "select avg(rating) from rating inner join movies on movies.id=rating.movie_id where movies.title = '" + title + "'";
            return jdbcTemplate.queryForObject(query, Double.class);
        }
        return -1;
    }

    public double getAvgRating(int sId, int movie_id) {
        if(customerAuthentication(sId)) {
            String query = "select avg(rating) from rating where movie_id = "+movie_id;
            return jdbcTemplate.queryForObject(query, Double.class);
        }
        return -1;
    }

    public List<History> viewAllHistory(int sId) {
        if(customerAuthentication(sId)) {
            String query = "select shows.id,customer.fname,customer.lname,movies.title,theatre.name,shows.seats from booking inner join shows on shows.id=booking.show_id inner join movies on shows.movie_id=movies.id inner join theatre on shows.theatre_id=theatre.id inner join customer on booking.cust_id=customer.id where booking.cust_id=" + customerId;
            return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(History.class));
        }
        return null;
    }
}
