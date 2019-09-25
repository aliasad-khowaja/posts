package com.webservice.posts.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/welcome")
    public String welcome() {
        return messageSource.getMessage("message.welcome", null, LocaleContextHolder.getLocale());
    }

}
