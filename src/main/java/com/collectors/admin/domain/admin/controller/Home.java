package com.collectors.admin.domain.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    // thymeleaf
    @GetMapping("/main")
    public String loginTest () {
        System.out.println("test success");
        return "thymeleaf/index3";

    }

    // jsp
    @GetMapping("/jsptest")
    public String jspTest () {
        System.out.println("test success jsp");
        return "test";

    }

    // jsp
    @GetMapping("/login")
    public String loginController () {
        System.out.println("test success login jsp");
        return "login";

    }
    
}
