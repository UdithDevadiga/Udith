package com.movie.ticket.controller;

import com.movie.ticket.modal.*;
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
    @GetMapping("/login/{id}")
    public int logIn(@PathVariable int id,@RequestBody long phNumber) {
        return customerService.logIn(id, phNumber);
    }
    @GetMapping("/viewDetails/{sId}")
    public Customer viewDetails(@PathVariable int sId) {
        return customerService.viewDetails(sId);
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
    @
    GetMapping("/viewAvailableSeats/{sId}/{show_id}")
    public int viewAvailableSeats(@PathVariable int sId,@PathVariable int show_id) {
        return customerService.getAvailableSeats(sId, show_id);
    }
    @PostMapping("/book/{sId}")
    public String booking(@PathVariable int sId,@RequestBody Booking booking) {
        return customerService.book(sId, booking);
    }
    @GetMapping("/viewHistory/{sId}")
    public List<Booking> viewHistory(@PathVariable int sId) {
        return customerService.viewHistory(sId);
    }
    @GetMapping("/TheatresNearMe/{sId}")

    public List<Theatre> viewTheatresNearMe(@PathVariable int sId) {
        return customerService.viewTheatresNearMe(sId);
    }
    @GetMapping("/viewTheatresByLocation/{sId}")
    public List<Theatre> viewTheatresByLocation(@PathVariable int sId, @RequestBody String location) {
        return customerService.viewTheatresByLocation(sId, location);
    }
    @PostMapping("/giveRating/{sId}")
    public String giveRating(@PathVariable int sId, @RequestBody Rating rating) {
        return customerService.giveRatings(sId, rating);
    }
    @GetMapping("/AvgMovieRating/{sId}/{movie_name}")
    public double getAvgRating(@PathVariable int sId, @PathVariable String movie_name) {
        return customerService.getAvgRating(sId, movie_name);
    }
    @GetMapping("/viewAvgMovieRating/{sId}/{movie_id}")
    public double viewAvgRating(@PathVariable int sId, @PathVariable int movie_id) {
        return customerService.getAvgRating(sId, movie_id);
    }
    @GetMapping("/viewAllHistory/{sId}")
    public List viewAllHistory(@PathVariable int sId) {
        return customerService.viewAllHistory(sId);
    }
}
