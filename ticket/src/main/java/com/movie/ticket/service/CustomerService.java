package com.movie.ticket.service;


import com.movie.ticket.modal.Customer;
import com.movie.ticket.modal.Movies;
import com.movie.ticket.modal.Shows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomerService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private int sessionId;

    public String register(Customer customer) {
        String query = "insert into customer values("+customer.getId()+",'"+customer.getFName()+"','"+customer.getLName()+"','"+customer.getPhNumber()+"','"+customer.getLocation()+"','"+customer.getEmail()+"')";
        jdbcTemplate.update(query);
        return "Registration is Done";
    }

    public int logIn(int id,long phNumber) {
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

    public Customer viewDetails(int sID,int customerId) {
        if(customerAuthentication(sID)) {
            String query = "select * from customer where id =" + customerId;
            List<Customer> customerList= jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Customer.class));
            return customerList.get(0);
        }
        return null;
    }

    public List<Movies> viewMoviesByName(int sID,String movieName) {
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







}
