package com.xiao.peppa.service;

import com.xiao.peppa.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
