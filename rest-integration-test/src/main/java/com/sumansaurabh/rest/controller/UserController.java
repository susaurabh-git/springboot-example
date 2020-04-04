package com.sumansaurabh.rest.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sumansaurabh.rest.dao.UserRepository;
import com.sumansaurabh.rest.model.User;
import com.sumansaurabh.rest.model.Users;

@RestController
public class UserController 
{
	@Autowired
    private UserRepository userRepository;

	@GetMapping(path="/users", produces = "application/json")
    public Users getUsers() 
    {
		Users response = new Users();
		ArrayList<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		response.setUserList(list);
        return response;
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
