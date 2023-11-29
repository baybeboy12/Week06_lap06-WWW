package com.example;

import com.example.backend.modules.User;
import com.example.backend.responsitory.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Optional;

@SpringBootApplication
public class Week06Lap06WwwApplication {
    @Autowired
    private UserResponsitory userResponsitory;
    public static void main(String[] args) {
        SpringApplication.run(Week06Lap06WwwApplication.class, args);
    }
//    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            User user1 = new User(
                    "user.getFirstName()","user.getMiddleName()",
                   " user.getLastName()","user.getMobile()",
                   " user.getEmail()","user.getPasswordHash()",
                    Instant.now(),null,"user.getIntro()","");
            userResponsitory.save(user1);
            Optional<User> op = userResponsitory.getloginAcount("dung@gmail.com","1234");
            System.out.println(op);
        };
    }
}
