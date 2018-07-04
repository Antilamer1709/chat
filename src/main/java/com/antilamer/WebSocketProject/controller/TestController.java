package com.antilamer.WebSocketProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public List<String> getAllTopics() {
        List<String> list = new ArrayList<>();
        list.add("Test");
        return list;
    }

}
