package com.collectors.admin.emailAuth.service;
import com.collectors.admin.emailAuth.repository.EmailRepo;
import com.collectors.admin.entity.EmailPassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    @Autowired
    EmailRepo emailRepo;

    // 회원가입시 이메일 인증코드 DB 저장
    public EmailPassEntity insertEmailPass(Map<String, Object> map){

        EmailPassEntity emailPassEntity = new EmailPassEntity();
        emailPassEntity.setPass(map.get("pass").toString());
        emailPassEntity.setEmail(map.get("emailAddress").toString());

        return  emailRepo.insertEmailPass(emailPassEntity);
    }

    // 회원가입시 이메일 인증코드 DB 확인
    public Boolean checkEmailCode(Map<String, Object> map){

        EmailPassEntity emailPassEntity = new EmailPassEntity();
        emailPassEntity.setPass(map.get("pass").toString());
        emailPassEntity.setEmail(map.get("email").toString());

        Long countPassL = emailRepo.confirmEmailCode(emailPassEntity);
        //int checkPass = Long.valueOf(Optional.ofNullable(countPassL).orElse(0L)).intValue();

        if (1 <= countPassL) {
            // 이메일 인증 번호 일치함
            return true;
        }
        return  false;
    }

    // 이메일 인증 confirm 남기기
    // confirm : Y, N
    public void confirmEmailCode(String confirm) {
        emailRepo.confirmEmailCode();

    }


    // 회원가입 시 이메일 중복 확인
    public Boolean checkUniqueEmail(Map<String, Object> map){

        Long uniqueEmail = emailRepo.checkUniqueEmail(map.get("email").toString());

        if (0 < uniqueEmail) {
            //
            return false;
        } else {
            return  true;
        }
    }

    // 이메일 인증 받았는지 확인


    // 이메일 인증 받았는지 확인
    public Boolean checkEmailAuth(String email, String confirm) {
        Long emailAuth = emailRepo.checkEmailAuth(email, confirm);
        if (0 < emailAuth) {
            return true;
        } else {
            return false;
        }
    }


}
