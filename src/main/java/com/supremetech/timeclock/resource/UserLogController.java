package com.supremetech.timeclock.resource;

import com.supremetech.timeclock.domain.UserLog;
import com.supremetech.timeclock.service.UserLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user-logs")
public class UserLogController {

    private final UserLogService userLogService;

    public UserLogController(UserLogService userLogService) {
        this.userLogService = userLogService;
    }

    @GetMapping
    private List<UserLog> getUserLogs() {
        return userLogService.findAll();
    }

    @GetMapping("user/{userId}")
    private List<UserLog> getUserLogs(@PathVariable Long userId) {
        return userLogService.getLogsForUser(userId);
    }

}
