package com.collectors.admin.member.service;

import com.collectors.admin.emailAuth.controller.EmailController;
import com.collectors.admin.emailAuth.interfaces.EmailCodeService;
import com.collectors.admin.entity.AdminEntity;
import com.collectors.admin.member.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;



    // 회원가입 시 admin 정보 저장
    public void signInAdmin(Map<String, Object> map) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setAdmId(map.get("email").toString());
        adminEntity.setAdmPass("pass");
        adminEntity.setAdmName("name");
        adminEntity.setTeamIdx(Integer.parseInt(map.get("department").toString()));
        adminEntity.setAdmPhone(map.get("phone").toString());
        adminEntity.setAdmCheck(map.get("authCheck").toString());
        loginRepo.signInAdmin(adminEntity);
    }








}
