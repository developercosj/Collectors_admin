package com.collectors.admin.emailAuth.service;
import com.collectors.admin.emailAuth.repository.EmailPassRepo;
import com.collectors.admin.entity.EmailPassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class EmailPassService {

    @Autowired
    EmailPassRepo emailPassRepo;

    public EmailPassEntity insertEmailPass(Map<String, Object> map){

        EmailPassEntity emailPassEntity = new EmailPassEntity();
        emailPassEntity.setPass(map.get("pass").toString());
        emailPassEntity.setEmail(map.get("emailAddress").toString());

        return  emailPassRepo.insertEmailPass(emailPassEntity);
    }

    public Boolean confirmEmailCode(Map<String, Object> map){

        EmailPassEntity emailPassEntity = new EmailPassEntity();
        emailPassEntity.setPass(map.get("pass").toString());
        emailPassEntity.setEmail(map.get("email").toString());

        Long countPassL = emailPassRepo.confirmEmailCode(emailPassEntity);
        //int checkPass = Long.valueOf(Optional.ofNullable(countPassL).orElse(0L)).intValue();

        if (1 <= countPassL) {
            // 이메일 인증 번호 일치함
            return true;
        }
        return  false;
    }
}
