package com.br.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class UserServiceApplication {

    @Profile({"dev", "prod"})
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
