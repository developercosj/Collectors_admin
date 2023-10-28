package com.collectors.admin.emailAuth.service;
import com.collectors.admin.emailAuth.repository.EmailPassRepo;
import com.collectors.admin.entity.EmailPassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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






}
