package com.collectors.admin.emailAuth.controller;


import com.collectors.admin.emailAuth.service.EmailPassService;
import com.collectors.admin.emailAuth.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmailController {

    // 회원가입시 이메일 인증
    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    EmailPassService emailPassService;

    @ResponseBody
    @RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
    public String emailConfirm(@RequestBody Map<String, Object> map) throws Exception {
        String confirmPass = emailService.sendSimpleMessage(String.valueOf(map.get("emailAddress")));
        // 생성된 비밀번호를 DB 에 임시 저장
        /**
         * TO_DO
         * Redis 로컬에 생성해서 서비스 DB말고 Redis 에 저장하여 처리
         */

        emailPassService.insertEmailPass(confirmPass);


        return confirmPass;
    }



}
