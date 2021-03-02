package com.supremetech.timeclock.resource;

import com.supremetech.timeclock.resource.dto.LoginDTO;
import com.supremetech.timeclock.service.SecurityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping(name = "login")
    public Boolean login(LoginDTO loginDTO) {
        return securityService.login(loginDTO.getUsername());
    }
}
