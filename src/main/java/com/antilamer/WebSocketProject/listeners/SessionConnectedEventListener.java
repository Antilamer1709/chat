package com.antilamer.WebSocketProject.listeners;

import com.antilamer.WebSocketProject.model.UserDTO;
import com.antilamer.WebSocketProject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Slf4j
@Component
public class SessionConnectedEventListener implements ApplicationListener<SessionConnectedEvent>  {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        userService.addConnectedUser(new UserDTO((Authentication) event.getUser()));
        template.convertAndSend("/chat", event.getUser().getName() + " - has been connected!");
        template.convertAndSend("/userList", userService.getConnectedUsers());
    }
}
