package com.rest.webservices.learning.rest.controller;

import com.rest.webservices.learning.rest.Exceptions.UserNotFoundException;
import com.rest.webservices.learning.rest.model.User;
import com.rest.webservices.learning.rest.userdao.userComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private userComponent usercom;


//    public UserController(userComponent usercom) {
//        this.usercom = usercom;
//    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return usercom.findAll();
    }

    @GetMapping("/users/{uid}")
    public User findByuserid(@PathVariable Integer uid) {
        User user = usercom.findByuid(uid);
        if (user == null)
            throw new UserNotFoundException("user id not located:" + uid);
        return user;

    }


    @PostMapping("/addusers")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = usercom.save(user);
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{uid}")
                .buildAndExpand(savedUser.getUid()).toUri();
        //return ResponseEntity.created(null).build();
        return ResponseEntity.created(loc).build();
    }

    @DeleteMapping("/deleteuser/{id}")
    public void deleteByUid(@PathVariable int id) {
        usercom.deleteById(id);

    }
}

