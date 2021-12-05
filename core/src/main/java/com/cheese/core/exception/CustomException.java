package com.cheese.core.exception;

import com.cheese.core.constants.CustomExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final CustomExceptionCode exceptionCode;
}
