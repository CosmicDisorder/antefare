package com.github.cosmicdisorder.antefare.service;

import com.github.cosmicdisorder.antefare.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
