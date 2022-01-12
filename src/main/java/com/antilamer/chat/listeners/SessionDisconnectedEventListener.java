package com.antilamer.chat.listeners;

import com.antilamer.chat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
public class SessionDisconnectedEventListener implements ApplicationListener<SessionDisconnectEvent> {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        userService.removeConnectedUserByUsername(event.getUser().getName());
        template.convertAndSend("/chat", event.getUser().getName() + " - has been disconnected!");
        template.convertAndSend("/userList", userService.getConnectedUsers());
    }
}