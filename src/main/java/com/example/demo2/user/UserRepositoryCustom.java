package com.example.demo2.user;

import java.util.List;

public interface UserRepositoryCustom {
    public List<User> getUserByUsername(String username);

    public User postUserData(User user);

    public List<User> insertUser(User user);

    public User loginUser(User user);
}
