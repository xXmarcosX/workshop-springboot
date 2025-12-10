package com.marcos.store.controllers;

import com.marcos.store.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findUser() {
        User user = new User(1L, "Marcos", "marcos@gmail.com", "1111111", "123456");

        return ResponseEntity.ok().body(user);
    }
}
