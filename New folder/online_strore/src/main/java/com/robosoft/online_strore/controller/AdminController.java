package com.robosoft.online_strore.controller;

import com.robosoft.online_strore.modal.Books;
import com.robosoft.online_strore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/addBook")
    public int addBook(@RequestBody Books book) {
        return adminService.addBook(book);
    }
    @DeleteMapping("/removeBooks")
    public int removeBooks() {
        return adminService.removeBooks();
    }
    @DeleteMapping("/removeBook/{id}")
    public int removeBook(@PathVariable int id) {
        return adminService.removeBookById(id);
    }
    @GetMapping("/adminViewBooks")
    public List<Books> viewBooks(){
        return adminService.viewBooks();
    }
    @GetMapping("adminViewBook/{id}")
    public Books viewBook(@PathVariable int id){
        return adminService.viewBookById(id);
    }
    @PutMapping("/increaseAmount/{id}")
    public int increaseBookAmount(@PathVariable int id,@RequestBody double amount) {
        return adminService.increaseBookAmount(id, amount);
    }

}
