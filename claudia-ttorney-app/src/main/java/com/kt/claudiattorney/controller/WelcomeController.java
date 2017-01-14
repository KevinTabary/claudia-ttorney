package com.kt.claudiattorney.controller;

import com.kt.claudiattorney.entity.Customer;
import com.kt.claudiattorney.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;

@Controller
public class WelcomeController {

    private final CustomerService customerService;

    @Autowired
    public WelcomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/test")
    public String welcome(Model model) {
        save();
        model.addAttribute("test", Instant.now());
        model.addAttribute("customers", customerService.findAll());
        return "test";
    }

    private void save() {
        customerService.save(Customer.builder()
                .firstName("kevin")
                .lastName("tabary")
                .address("4 allée des frênes")
                .build());
    }
}
