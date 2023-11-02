package com.collectors.admin.common;

import lombok.Getter;

@Getter
public enum StatusEnum {

    EMAILCODE_SEND_SUCCESS(200, "OK", "이메일 코드가 정상적으로 전송되었습니다."),
    EMAILCODE_CONFIRM_SUCCESS(200, "OK", "이메일 인증이 되었습니다."),
    EMAILCODE_CONFIRM_FAIL(200, "OK", "이메일 코드가 틀렸습니다."),
    EMAILCODE_UNIQUE_FAIL(200, "OK", "이메일이 중복됩니다."),
    BAD_REQUEST(400, "BAD_REQUEST", ""),
    NOT_FOUND(404, "NOT_FOUND", ""),
    INTERNAL_SERER_ERROR(500, "INTERNAL_SERER_ERROR", "");


    int statusCode;
    String code;
    String message;



    StatusEnum(int statusCode, String code, String message) {
        this.statusCode = statusCode;
        this.code = code;
        this.message = message;
    }
}
