package com.collectors.admin.emailAuth.controller;


import com.collectors.admin.emailAuth.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class emailController {

    // 회원가입시 이메일 인증
    @Autowired
    EmailServiceImpl emailService;
    public String emailConfirm(@RequestParam String emailAddress) throws Exception {
        String confirm = emailService.sendSimpleMessage(emailAddress);
        return confirm;
    }



}
