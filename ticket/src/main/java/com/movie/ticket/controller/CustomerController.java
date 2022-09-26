package com.movie.ticket.controller;

import com.movie.ticket.modal.Customer;
import com.movie.ticket.modal.Movies;
import com.movie.ticket.modal.Shows;
import com.movie.ticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/registration")
    public String registration(@RequestBody Customer customer) {
        return customerService.register(customer);
    }
    @GetMapping("/login")
    public int logIn(@RequestBody int id,@RequestBody long phNumber) {
        return customerService.logIn(id, phNumber);
    }
    @GetMapping("/viewDetails/{sId}/{customerId}")
    public Customer viewDetails(@PathVariable int sId,@PathVariable int customerId) {
        return customerService.viewDetails(sId,customerId);
    }
    @GetMapping("movieDetails/{sId}/{movieName}")
    public List<Movies> MovieDetailsByName(@PathVariable int sId,@PathVariable String movieName) {
        return customerService.viewMoviesByName(sId, movieName);
    }
    @GetMapping("movieDetails/{sId}")
    public List<Movies> MovieDetails(@PathVariable int sId) {
        return customerService.viewMovies(sId);
    }
    @GetMapping("viewShows/{sId}")
    public List<Shows> viewShows(@PathVariable int sId) {
        return customerService.viewShows(sId);
    }




}
