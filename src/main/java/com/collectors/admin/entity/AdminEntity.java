package com.collectors.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@ToString
@Builder
@AllArgsConstructor
@Entity(name = "admin" )
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String admId;
    private String admPass;
    private String admName;
    private int teamIdx;
    private String loginDate;
    private String startDate;
    private String leaveDate;
    private String admPhone;
    private String admCheck;


    public AdminEntity() {

    }
}
