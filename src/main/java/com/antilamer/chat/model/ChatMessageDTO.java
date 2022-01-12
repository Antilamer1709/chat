package com.antilamer.chat.model;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessageDTO {

    private final String message;
    private final Principal user;

    public ChatMessageDTO(Principal user, String message) {
        this.user = user;
        this.message = message;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date()) +
                " " +
                this.user.getName() +
                " - " +
                this.message;
    }
}