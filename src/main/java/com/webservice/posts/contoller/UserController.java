package com.webservice.posts.contoller;

import com.webservice.posts.exception.UserNotFoundException;
import com.webservice.posts.model.User;
import com.webservice.posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> list() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        User user = userService.get(id);
        if( user == null ) {
            throw new UserNotFoundException(messageSource.getMessage("user.error.not.found",
                    new Object[]{id}, LocaleContextHolder.getLocale()));
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Void> save(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        User user = userService.get(id);
        if( user == null ) {
            throw new UserNotFoundException(messageSource.getMessage("user.error.not.found",
                    new Object[]{id}, LocaleContextHolder.getLocale()));
        }
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(path = "/users/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User updatingUser) {
        User user = userService.get(id);
        if( user == null ) {
            throw new UserNotFoundException(messageSource.getMessage("user.error.not.found",
                    new Object[]{id}, LocaleContextHolder.getLocale()));
        }
        updatingUser.setId(id);
        return ResponseEntity.ok( userService.save(updatingUser) );
    }

}
