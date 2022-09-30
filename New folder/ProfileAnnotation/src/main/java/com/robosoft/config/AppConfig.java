package com.robosoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("dev")
public class AppConfig {
    @PostConstruct
    public void print() {
        System.out.println("Fall Back");
    }
}
