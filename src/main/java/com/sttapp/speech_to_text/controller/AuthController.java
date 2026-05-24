package com.sttapp.speech_to_text.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sttapp.speech_to_text.model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(
            @RequestBody User user
    ) {
        return "User Registered: "
                + user.getName();
    }

}