package com.antilamer.chat.controller;

import com.antilamer.chat.model.UserDTO;
import com.antilamer.chat.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/loggedUser")
    public UserDTO loggedUser() {
        log.debug("*** loggedUser()");
        return authenticationService.getLoggedUserDTO();
    }

}