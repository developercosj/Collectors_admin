package com.collectors.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@Entity(name = "adm_dept" )
public class AdmDeptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idx;
    String teamName;
    String startDate;
    int admMakeIdx;
    int teamDirector;


    public AdmDeptEntity() {

    }
}
