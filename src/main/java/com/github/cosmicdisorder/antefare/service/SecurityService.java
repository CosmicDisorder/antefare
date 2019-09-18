package com.github.cosmicdisorder.antefare.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
