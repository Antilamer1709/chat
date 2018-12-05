package com.antilamer.WebSocketProject.service;

import com.antilamer.WebSocketProject.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<UserDTO> connectedUsers = new ArrayList<>();


    public void addConnectedUser(UserDTO user) {
        connectedUsers.add(user);
    }

    public void removeConnectedUserByUsername(String username) {
        connectedUsers.removeIf(x -> x.getUsername().equals(username));
    }

    public List<UserDTO> getConnectedUsers() {
        return connectedUsers;
    }
}
