package com.robosoft.onetoone.controller;

import com.robosoft.onetoone.modal.Laptop;
import com.robosoft.onetoone.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @PostMapping("/saveLaptop")
    public Laptop saveLaptop(@RequestBody Laptop laptop){
        return laptopService.saveLaptop(laptop);
    }
    @GetMapping("/getLaptop")
    public List<Laptop> getLaptop(){
        return laptopService.getLaptop();
    }
}
