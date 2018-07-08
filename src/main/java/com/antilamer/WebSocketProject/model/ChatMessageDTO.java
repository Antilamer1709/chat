package com.antilamer.WebSocketProject.model;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessageDTO {

    private Principal user;

    private String message;

    public ChatMessageDTO(Principal user, String message) {
        this.user = user;
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        sb.append(" ");
        sb.append(this.user.getName());
        sb.append(" - ");
        sb.append(this.message);

        return sb.toString();
    }
}
