package com.example.backend.service;

import org.springframework.stereotype.Service;

public interface UserService {
    Integer login(String username, String password);
}
