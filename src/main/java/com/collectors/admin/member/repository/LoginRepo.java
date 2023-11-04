package com.collectors.admin.member.repository;

import com.collectors.admin.entity.AdminEntity;
import com.collectors.admin.jpaRepo.AdminJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class LoginRepo {

    @Autowired
    AdminJpaRepo adminJpaRepo;

    public void signInAdmin(AdminEntity adminEntity) {
        adminJpaRepo.save(adminEntity);
    }





}
