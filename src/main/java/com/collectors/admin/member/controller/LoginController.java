package com.collectors.admin.member.controller;

import com.collectors.admin.common.ResponseMessage;
import com.collectors.admin.common.StatusEnum;
import com.collectors.admin.emailAuth.controller.EmailController;
import com.collectors.admin.emailAuth.service.EmailService;
import com.collectors.admin.entity.AdminEntity;
import com.collectors.admin.member.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    // 회원가입

    @ResponseBody
    @RequestMapping(value = "/signInAdmin", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> signInAdmin(@RequestParam Map<String, Object> map){
        System.out.println(map);
        ResponseMessage message;
        // 이메일 유니크 체크
        EmailController emailController = new EmailController();
        Boolean uniqueEmail = emailController.checkEmailUnique(map);

        if (uniqueEmail == false) {
            message = new ResponseMessage(StatusEnum.EMAIL_UNIQUE_FAIL);
            message.setStatus(StatusEnum.EMAIL_UNIQUE_FAIL);
            message.setMessage(StatusEnum.EMAIL_UNIQUE_FAIL.getMessage());
            // 만약 데이터를 전송하고 싶을때
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        // 이메일 인증 받았는지 확인
        EmailService emailService = new EmailService();
        Boolean checkEmailAuth = emailService.checkEmailAuth(map.get("email").toString(),"Y");
        if (checkEmailAuth == false) {
            message = new ResponseMessage(StatusEnum.EMAIL_CONFIRM_FAIL);
            message.setStatus(StatusEnum.EMAIL_CONFIRM_FAIL);
            message.setMessage(StatusEnum.EMAIL_CONFIRM_FAIL.getMessage());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        // 이메일 저장
        loginService.signInAdmin(map);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
