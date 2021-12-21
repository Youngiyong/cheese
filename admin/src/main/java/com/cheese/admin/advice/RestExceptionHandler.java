package com.cheese.admin.advice;

import com.cheese.admin.error.ErrorCode;
import com.cheese.admin.exception.CustomException;
import com.cheese.admin.exception.InvalidParameterException;
import com.cheese.admin.model.response.CustomErrorResponse;
import com.cheese.admin.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        log.error("handleHttpRequestMethodNotSupportedException", e);
//
//        final ErrorResponse response = ErrorResponse
//                .builder()
//                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
//                .message(e.getMessage());
//
//        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
//    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     */
//    @ExceptionHandler(AccessDeniedException.class)
//    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
//        log.error("handleAccessDeniedException", e);
//
//        final ErrorResponse response = ErrorResponse
//                .builder()
//                .status(ErrorCode.HANDLE_ACCESS_DENIED.getStatus())
//                .message(e.getMessage());
//
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.HANDLE_ACCESS_DENIED.getStatus()));
//    }



    /**
     *   @Valid 검증 실패 시 Catch
     */
    @ExceptionHandler(InvalidParameterException.class)
    protected ResponseEntity<CustomErrorResponse> handleInvalidParameterException(InvalidParameterException e) {
        log.error("handleInvalidParameterException", e);
        ErrorCode errorCode = e.getErrorCode();

        final CustomErrorResponse response = CustomErrorResponse
                .builder()
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .errors(e.getErrors());

        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getStatus()));
    }

    /**
     *  CustomException을 상속받은 클래스가 예외를 발생 시킬 시, Catch하여 ErrorResponse를 반환한다.
     */
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleAllException", e);

        ErrorCode errorCode = e.getErrorCode();

        ErrorResponse response = ErrorResponse
                .builder()
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(e.toString());

        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getStatus()));
    }
}