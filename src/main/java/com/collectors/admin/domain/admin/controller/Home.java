package com.collectors.admin.domain.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/login")
    public String loginTest () {
        System.out.println("test success"); 

        return "/login"; 

    }
    
}
