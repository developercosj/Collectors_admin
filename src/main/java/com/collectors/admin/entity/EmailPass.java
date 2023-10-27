package com.collectors.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Data
@ToString
@Builder
@AllArgsConstructor
@Entity(name = "emailPass" )
public class EmailPass {


    @Id
    private Long idx;
    private String email;
    private String pass;
    private String regDate;


    public EmailPass() {

    }
}
