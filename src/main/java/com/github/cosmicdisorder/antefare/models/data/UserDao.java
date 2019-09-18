package com.github.cosmicdisorder.antefare.models.data;

import com.github.cosmicdisorder.antefare.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}