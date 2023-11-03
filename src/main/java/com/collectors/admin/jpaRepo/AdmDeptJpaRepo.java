package com.collectors.admin.jpaRepo;

import com.collectors.admin.entity.AdmDeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmDeptJpaRepo  extends JpaRepository<AdmDeptEntity, Long> {
}
