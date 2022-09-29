package com.nigerians.scamazone;

import com.nigerians.scamazone.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScamazoneApplication {
    private static final UserController userController = new UserController();
    public static void main(String[] args) {
        SpringApplication.run(ScamazoneApplication.class, args);
    }
}
