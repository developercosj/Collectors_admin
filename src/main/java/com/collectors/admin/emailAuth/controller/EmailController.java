package com.collectors.admin.emailAuth.controller;


import com.collectors.admin.common.ResponseMessage;
import com.collectors.admin.common.StatusEnum;
import com.collectors.admin.dto.ResultDto;
import com.collectors.admin.emailAuth.service.EmailPassService;
import com.collectors.admin.emailAuth.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.function.Function;

@Controller
public class EmailController {


    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    EmailPassService emailPassService;

    // 회원가입시 이메일 인증코드 전송
    @ResponseBody
    @RequestMapping(value = "/sendEmailCode", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> sendEmailCode(@RequestBody Map<String, Object> map) throws Exception {
        String pass = emailService.sendSimpleMessage(String.valueOf(map.get("emailAddress")));
        map.put("pass", pass);
        // 생성된 비밀번호를 DB 에 임시 저장
        /**
         * TO_DO
         * Redis 로컬에 생성해서 서비스 DB말고 Redis에 저장하여 처리
         */
       emailPassService.insertEmailPass(map);

        ResponseMessage message = new ResponseMessage(StatusEnum.EMAILCODE_SEND_SUCCESS);
        message.setStatus(StatusEnum.EMAILCODE_SEND_SUCCESS);
        message.setMessage(StatusEnum.EMAILCODE_SEND_SUCCESS.getMessage());
        // 만약 데이터를 전송하고 싶을때
        //message.setData("객체");

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // 이메일 인증코드 확인
    @ResponseBody
    @RequestMapping(value = "/confirmEmailCode", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> confirmEmailCode(@RequestBody Map<String, Object> map) {


      Boolean checkEmailCode =  emailPassService.confirmEmailCode(map);
      ResponseMessage message;
      if (checkEmailCode == true) {
          message = new ResponseMessage(StatusEnum.EMAILCODE_CONFIRM_SUCCESS);
          message.setStatus(StatusEnum.EMAILCODE_CONFIRM_SUCCESS);
          message.setMessage(StatusEnum.EMAILCODE_CONFIRM_SUCCESS.getMessage());
      } else {
          message = new ResponseMessage(StatusEnum.EMAILCODE_CONFIRM_FAIL);
      }




      return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
