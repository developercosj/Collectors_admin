package com.collectors.admin.common;

import lombok.Data;

@Data
public class ResponseMessage {

    private  StatusEnum status;
    private String message;
    private Object data;


    public ResponseMessage(StatusEnum status) {
        this.status = status;
    }
}
