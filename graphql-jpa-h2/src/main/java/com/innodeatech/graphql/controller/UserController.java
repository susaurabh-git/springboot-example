package com.innodeatech.graphql.controller;

import com.innodeatech.graphql.dao.UserRepository;
import com.innodeatech.graphql.entity.User;
import com.innodeatech.graphql.model.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @QueryMapping
    public Iterable<User> users() {
        return userRepository.findAll();
    }

    @QueryMapping
    public Optional<User> userById(@Argument(name = "id") Long id) {
        return userRepository.findById(id);
    }

    @MutationMapping
    public User addUser(@Argument(name = "user") CreateUser user) {
        User newUser = new User (user.firstName(), user.lastName(),user.email());
        return userRepository.save(newUser);
    }
}