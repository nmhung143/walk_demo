package com.demo.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Getter
public enum ErrorCode {
    NOT_FOUND_USER("W001", HttpStatus.NOT_FOUND, "User not found"),
    ;

    private final String errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(String errorCode, HttpStatus httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
