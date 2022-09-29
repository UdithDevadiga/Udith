package com.robosoft.springboothelloworldexample;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class HelloWorldController {
    Scanner sc=new Scanner(System.in);
    @RequestMapping("/")
    public String hello(){
        return sc.next();
    }
}
