package com.demo.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class WalkException extends RuntimeException {
    private String errorCode;
    private HttpStatus httpStatus;
    private String message;

    public WalkException(ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }
}
