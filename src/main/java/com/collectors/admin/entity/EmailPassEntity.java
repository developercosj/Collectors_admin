package com.collectors.admin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Time;
import java.sql.Timestamp;


@Data
@ToString
@Builder
@AllArgsConstructor
@Entity(name = "email_pass" )
public class EmailPassEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String pass;
    // reg_date 자동 입력
    @UpdateTimestamp
    private String regDate;

    @Builder.Default
    private String confirm = "N";
    private Timestamp confirm_date;


    public EmailPassEntity() {

    }
}
