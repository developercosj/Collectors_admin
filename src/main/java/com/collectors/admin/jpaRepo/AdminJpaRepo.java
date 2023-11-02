package com.collectors.admin.jpaRepo;

import com.collectors.admin.entity.AdminEntity;
import com.collectors.admin.entity.EmailPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpaRepo extends JpaRepository<AdminEntity, Long> {
    Long countByAdmId(String AdmId);


}
