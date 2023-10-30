package com.collectors.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ResultDto<T> {

    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;


    public ResultDto(final HttpStatus statusCode, final String resultMsg) {
        this.statusCode = statusCode;
        this.resultMsg = resultMsg;
        this.resultData = null;
    }

    // 제네릭 메소드
    public static <T> ResultDto<T> res(final HttpStatus statusCode, final String resultMsg) {
        return res(statusCode, resultMsg, null);
    }

    // 빌더 패턴
    public static <T> ResultDto<T> res(final HttpStatus statusCode, final String resultMsg, final T t){
        return ResultDto.<T>builder()
                .resultData(t)
                .statusCode(statusCode)
                .resultMsg(resultMsg)
                .build();
    }











}
