package us.innodea.rest.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import us.innodea.rest.redis.model.CreateUserRequest;
import us.innodea.rest.redis.model.User;
import us.innodea.rest.redis.service.UserService;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public User createUser(@RequestBody CreateUserRequest request){
        log.info("Create User: {}", request);
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        log.info("Get User: {}", id);
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        log.info("delete User: {}", id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody CreateUserRequest request){
        log.info("Update User: {}", request);
        return userService.updateUser(request);
    }

}

