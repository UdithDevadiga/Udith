package com.movie.ticket.controller;

import com.movie.ticket.modal.Admin;
import com.movie.ticket.modal.Movies;
import com.movie.ticket.modal.Shows;
import com.movie.ticket.modal.Theatre;
import com.movie.ticket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/register")
    public String register(@RequestBody Admin admin) {
        return adminService.adminRegister(admin);
    }
    @PostMapping("/addMovies/{password}")
    public String addMovies(@RequestBody Movies movies,@PathVariable String password) {
        return adminService.addMovies(movies,password);
    }
    @PostMapping("/addTheatre/{password}")
    public String addTheatre(@RequestBody Theatre theatre,@PathVariable String password) {
        return  adminService.addTheatre(theatre,password);
    }
    @PostMapping("/addShows/{password}")
    public String addShows(@RequestBody Shows shows,@PathVariable String password) {
        return adminService.addShows(shows,password);
    }
    @GetMapping("/viewTheatre/{movie_id}/{password}")
    public List viewTheatre(@PathVariable int movie_id,@PathVariable String password) {
        return adminService.viewTheatresByMovieId(movie_id,password);
    }
    @PutMapping("/updateMovies/{password}")
    public String updateMovie(@RequestBody Movies movies,@PathVariable String password) {
        return adminService.updateMovie(movies,password);
    }
}
