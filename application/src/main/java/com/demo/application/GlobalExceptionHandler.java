package com.demo.application;

import com.demo.common.exception.WalkException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WalkException.class)
    private ResponseEntity<ExceptionResp> handleWalkException(WalkException ex) {
        var resp = new ExceptionResp(ex.getErrorCode().getErrorCode(), ex.getErrorCode().getMessage());
        return new ResponseEntity<>(resp, ex.getErrorCode().getHttpStatus());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ExceptionResp {
        private String errorCode;
        private String message;
    }
}
