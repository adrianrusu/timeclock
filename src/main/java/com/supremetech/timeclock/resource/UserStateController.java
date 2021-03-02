package com.supremetech.timeclock.resource;

import com.supremetech.timeclock.domain.UserLog;
import com.supremetech.timeclock.resource.dto.NewStateDTO;
import com.supremetech.timeclock.service.UserLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-states")
public class UserStateController {

    private final UserLogService userLogService;

    public UserStateController(UserLogService userLogService) {
        this.userLogService = userLogService;
    }

    @GetMapping("latest/{userId}")
    public UserLog getCurrentState(@PathVariable Long userId) {
        return userLogService.getLatestLogForUser(userId);
    }

    @PostMapping
    private UserLog changeState(@RequestBody NewStateDTO newState) {
        return userLogService.addLog(newState.getUserId(), newState.getUserState());
    }

}
