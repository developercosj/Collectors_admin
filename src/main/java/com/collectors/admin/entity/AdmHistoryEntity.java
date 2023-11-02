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
@Entity(name = "adm_history" )
public class AdmHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idx;
    String admId;
    String admPass;
    String admName;
    int teamIdx;
    String loginDate;
    String startDate;
    String leaveDate;
    String admPhone;
    String admCheck;
    String regDate;

    public AdmHistoryEntity() {

    }
}
