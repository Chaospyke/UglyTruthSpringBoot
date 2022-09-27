package com.example.demo2.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public User getUser2(Long id){
        return userRepository.getReferenceById(id);
    }

    public List<User> getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public User postUserData(User user){
        return userRepository.postUserData(user);
    }

    public List<User> insertUser(User user){
        return userRepository.insertUser(user);
    }

    public User loginUser(User user){
        return userRepository.loginUser(user);
    }
}
