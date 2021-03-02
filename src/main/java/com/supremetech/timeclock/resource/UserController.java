package com.supremetech.timeclock.resource;

import com.supremetech.timeclock.domain.User;
import com.supremetech.timeclock.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findUsers();
    }

    @GetMapping("{username}")
    public User findUserByName(@PathVariable String username) {
        return userService.findByUsername(username);
    }

}
