package com.supremetech.timeclock.service;

import com.supremetech.timeclock.domain.User;
import com.supremetech.timeclock.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
    }

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

}
