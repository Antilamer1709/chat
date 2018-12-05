package com.antilamer.WebSocketProject.configuration.webSocket;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketSessionListener {

    @EventListener
    public void connectionEstablished(SessionConnectedEvent event) {
        System.out.println(event);

    }

    @EventListener
    public void webSockectDisconnect(SessionDisconnectEvent event) {
        System.out.println(event);
    }
}