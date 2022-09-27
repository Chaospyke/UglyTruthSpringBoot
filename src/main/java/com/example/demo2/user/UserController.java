package com.example.demo2.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value ="/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/getUser")
    public Optional<User> getUser(Long id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/getUser2")
    public User getUser2(Long id){
        return userService.getUser2(id);
    }

    @PostMapping(
        value = "/getUserByUsername",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
        )
    public List<User> getUserByUsername(@RequestBody UserRequest username){
        return userService.getUserByUsername(username.getUsername());
    }

    @PostMapping(
        value = "/postUserData",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public User postUserData(@RequestBody User user){
        return userService.postUserData(user);
    }

    @PostMapping(
        value = "/insertUser",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<User> insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @PostMapping(
        value = "/loginUser",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public User loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }
}
