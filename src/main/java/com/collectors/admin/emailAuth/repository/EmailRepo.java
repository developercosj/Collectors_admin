package com.collectors.admin.emailAuth.repository;

import com.collectors.admin.entity.EmailPassEntity;
import com.collectors.admin.jpaRepo.AdminJpaRepo;
import com.collectors.admin.jpaRepo.EmailPassJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepo {

    @Autowired
    EmailPassJpaRepo emailPassJpaRepo;

    @Autowired
    AdminJpaRepo adminJpaRepo;



    // email로 EmailPass 객체 찾기
    public EmailPassEntity findEmailPassByEmail(String email) {
        EmailPassEntity emailPassEntity = emailPassJpaRepo.findByEmail(email);
        return emailPassEntity;
    }

    public EmailPassEntity insertEmailPass(EmailPassEntity emailPassEntity){
        // 비밀번호 저장
        EmailPassEntity result = emailPassJpaRepo.save(emailPassEntity);
        System.out.println("result = " + result);
        return result;
    }

    public Long checkEmailCodeAuth(EmailPassEntity emailPassEntity){
        // 이메일 인증번호 확인
        String pass = emailPassEntity.getPass();
        String email = emailPassEntity.getEmail();

        Long result = emailPassJpaRepo.countByPassAndEmail(pass, email);
        System.out.println("result = " + result);
        return result;
    }

    // 인증 확인 confirm N -> Y
    public void confirmEmailPass(EmailPassEntity emailPassEntity) {
        emailPassJpaRepo.save(emailPassEntity);
    }


    public Long checkUniqueEmail(String email){
        Long result = adminJpaRepo.countByAdmId(email);
        return result;
    }

    public Long checkEmailAuth(String email, String confirm){
        Long result = emailPassJpaRepo.countByEmailAndConfirm(email, confirm);
        return result;
    }





}
