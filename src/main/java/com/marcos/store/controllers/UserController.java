package com.marcos.store.controllers;

import com.marcos.store.models.User;
import com.marcos.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findUser() {
        List<User> users = service.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(
            @PathVariable
            Long id
    ) {
        User user = service.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(
            @RequestBody
            User user
    ) {
        user = service.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable
            Long id
    ) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(
            @PathVariable
            Long id,

            @RequestBody
            User user
    ) {
        user = service.update(id, user);

        return ResponseEntity.ok().body(user);
    }
}
