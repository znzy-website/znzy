package com.example.backend.service;

import com.example.backend.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User login(String username, String password);

    User getUserById(Integer id);
}
