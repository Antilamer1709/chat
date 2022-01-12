package com.antilamer.chat.controller;

import com.antilamer.chat.model.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void onReceivedMessage(SimpMessageHeaderAccessor headerAccessor, String message) {
        ChatMessageDTO messageDTO = new ChatMessageDTO(headerAccessor.getUser(), message);
        this.template.convertAndSend("/chat", messageDTO.toString());
    }
}