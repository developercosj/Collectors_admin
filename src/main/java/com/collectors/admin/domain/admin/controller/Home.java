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
        return "test";

    }

    // 로그인 페이지 이동
    @GetMapping("/login")
    public String login () {
        return "login";

    }

    // 회원가입 페이지 이동
    @GetMapping("/register.do")
    public String register () {
        return "register";

    }
    
}
