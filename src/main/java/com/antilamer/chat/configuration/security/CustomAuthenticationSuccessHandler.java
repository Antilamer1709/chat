package com.antilamer.chat.configuration.security;

import com.antilamer.chat.model.UserDTO;
import com.antilamer.chat.service.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ObjectMapper mapper;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        UserDTO user = authenticationService.getLoggedUserDTO();
        sendResponse(response, user);
    }

    private void sendResponse(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(object));
        response.setStatus(HttpServletResponse.SC_OK);
        writer.flush();
        writer.close();
    }
}