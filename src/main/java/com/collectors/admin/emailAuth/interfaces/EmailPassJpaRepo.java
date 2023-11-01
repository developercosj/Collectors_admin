package com.collectors.admin.emailAuth.interfaces;

import com.collectors.admin.entity.EmailPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailPassJpaRepo  extends JpaRepository<EmailPassEntity, Long> {


    Long countByPassAndEmail(String pass, String email);

}
