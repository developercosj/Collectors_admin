package com.collectors.admin.dept.service;

import com.collectors.admin.dept.repository.DeptRepo;
import com.collectors.admin.entity.AdmDeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptRepo deptRepo;

    // adm_dept 테이블 부서리스트 조회
    public List<AdmDeptEntity> selectDeptList() {
        return deptRepo.selectDeptList();
    }



}
