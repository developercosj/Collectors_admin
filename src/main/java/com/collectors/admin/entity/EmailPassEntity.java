package com.collectors.admin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@ToString
@Builder
@AllArgsConstructor
@Entity(name = "EmailPass" )
public class EmailPassEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String pass;

    // reg_date 자동 입력
    @UpdateTimestamp
    private String regDate;


    public EmailPassEntity() {

    }
}
