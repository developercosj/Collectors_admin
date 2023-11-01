package com.collectors.admin.emailAuth.repository;

import com.collectors.admin.emailAuth.interfaces.EmailPassJpaRepo;
import com.collectors.admin.entity.EmailPassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailPassRepo {

    @Autowired
    EmailPassJpaRepo emailPassJpaRepo;
    public EmailPassEntity insertEmailPass(EmailPassEntity emailPassEntity){
        // 비밀번호 저장
        EmailPassEntity result = emailPassJpaRepo.save(emailPassEntity);
        System.out.println("result = " + result);
        return result;
    }

    public Long confirmEmailCode(EmailPassEntity emailPassEntity){
        // 이메일 인증번호 확인
        String pass = emailPassEntity.getPass();
        String email = emailPassEntity.getEmail();

        Long result = emailPassJpaRepo.countByPassAndEmail(pass, email);
        System.out.println("result = " + result);
        return result;
    }





}
