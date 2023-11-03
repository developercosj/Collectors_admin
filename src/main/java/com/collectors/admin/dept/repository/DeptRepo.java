package com.collectors.admin.dept.repository;

import com.collectors.admin.entity.AdmDeptEntity;
import com.collectors.admin.jpaRepo.AdmDeptJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptRepo {

    @Autowired
    AdmDeptJpaRepo admDeptJpaRepo;

    // adm_dept 테이블 부서리스트 조회
    public List<AdmDeptEntity> selectDeptList() {
        // adm_dept 테이블 부서리스트 조회
        return admDeptJpaRepo.findAll();
    }



}
