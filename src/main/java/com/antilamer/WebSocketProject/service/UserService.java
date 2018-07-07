package com.antilamer.WebSocketProject.service;

import com.antilamer.WebSocketProject.model.Notifications;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Notifications notifications = new Notifications(0);

    public void increment() {
        notifications.increment();
    }

    public void decrement() {
        notifications.decrement();
    }

    public Notifications getNotifications() {
        return notifications;
    }
}
