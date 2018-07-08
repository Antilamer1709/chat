package com.antilamer.WebSocketProject.service;

import com.antilamer.WebSocketProject.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService {

    public UserDetails getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_ANONYMOUS")) {
                return null;
            }
        }
        return (UserDetails) authentication.getPrincipal();
    }

    public UserDTO getLoggedUserDTO() {
        UserDetails user = getLoggedUser();
        if (user != null) {
            UserDTO userDTO = new UserDTO(user);
            log.debug("*** getLoggedUserDTO() userDTO: " + userDTO);
            return userDTO;
        } else {
            log.debug("*** getLoggedUserDTO() userDTO: anonymous");
            return null;
        }
    }

}
