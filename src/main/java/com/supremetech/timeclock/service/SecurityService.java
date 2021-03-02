package com.supremetech.timeclock.service;

import com.supremetech.timeclock.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private final UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean login(String username) {
        return true;
    }

}
