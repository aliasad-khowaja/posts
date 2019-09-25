package com.webservice.posts.bootstrap;

import com.webservice.posts.model.User;
import com.webservice.posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ApplicationBootstrap implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.save(new User("Asad", LocalDate.parse("1992-10-29")));
        userService.save(new User("Uzaid", LocalDate.parse("1993-01-20")));
        userService.save(new User("Fahad", LocalDate.parse("1995-08-02")));
    }
}
