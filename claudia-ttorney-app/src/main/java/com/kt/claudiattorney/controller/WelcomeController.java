package com.kt.claudiattorney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;

@Controller
public class WelcomeController {

    @GetMapping(path = "/test")
    public String welcome(Model model) {
        model.addAttribute("test", Instant.now());
        return "test";
    }
}
