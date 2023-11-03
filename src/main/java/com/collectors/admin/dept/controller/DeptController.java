package com.collectors.admin.dept.controller;

import com.collectors.admin.common.ResponseMessage;
import com.collectors.admin.dept.service.DeptService;
import com.collectors.admin.entity.AdmDeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    DeptService deptService;

    // adm_dept 테이블 부서리스트 조회
    @ResponseBody
    @RequestMapping(value = "/selectDeptList", method = RequestMethod.GET)
    public List<AdmDeptEntity> selectDeptList() {
        List<AdmDeptEntity> deptList = deptService.selectDeptList();
        return deptList;

    }


}
