package com.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Getter
@Setter
public class WalkException extends RuntimeException {
    private final transient ErrorCode errorCode;

    public WalkException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
