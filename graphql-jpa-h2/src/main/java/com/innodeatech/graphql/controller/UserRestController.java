package com.innodeatech.graphql.controller;

import com.innodeatech.graphql.dao.UserRepository;
import com.innodeatech.graphql.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

@RestController
public class UserRestController
{
	@Autowired
    private UserRepository userRepository;

	@GetMapping(path="/users", produces = "application/json")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    
    @PostMapping(path= "/users", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUser(@RequestBody User user) {       
                
        //add resource
    	user = userRepository.save(user);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(user.getId())
                                    .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
