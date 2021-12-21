package com.cheese.admin.advice;

import com.cheese.admin.exception.ServerRuntimeException;
import com.cheese.admin.model.Status;
import com.cheese.admin.model.transport.AdapterServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.InvalidParameterException;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerRuntimeException.class)
    protected ResponseEntity<AdapterServerResponse> handleServerRuntimeException(ServerRuntimeException ex, WebRequest request) {
        log.error("ServerRuntimeException {}({})", ex.getErrorCode(), ex.getErrorCode().getCode());
        log.error(ex.getLocalizedMessage());

        log.error("ServerRuntimeException::stack trace:", ex);
        Throwable cause = ex.getCause();
        log.error("ServerRuntimeException::cause: " + (cause == null ? "<none>" : cause.getMessage()));

        if (cause != null) {
            log.error("cause::stack trace: ", cause);
        }

        AdapterServerResponse serverResponse = new AdapterServerResponse();
        serverResponse.setStatus(Status.FAILED);
        serverResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(serverResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<AdapterServerResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.error("Unhandled Exception", ex);
        log.error(ex.getMessage());

        Throwable cause = ex.getCause();
        log.error("Unhandled exception::cause: " + (cause == null ? "<none>" : cause.getMessage()));
        if (cause != null) {
            log.error("cause::stack trace: ", cause);
        }

        AdapterServerResponse serverResponse = new AdapterServerResponse();
        serverResponse.setStatus(Status.FAILED);
        serverResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(serverResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<AdapterServerResponse> handleRestOfException(Exception ex, WebRequest request) {
        log.error("Unhandled Exception", ex);
        log.error(ex.getMessage());

        Throwable cause = ex.getCause();
        log.error("Unhandled exception::cause: " + (cause == null ? "<none>" : cause.getMessage()));
        if (cause != null) {
            log.error("cause::stack trace: ", cause);
        }

        AdapterServerResponse serverResponse = new AdapterServerResponse();
        serverResponse.setStatus(Status.FAILED);
        serverResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(serverResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidParameterException.class)
    protected ResponseEntity<AdapterServerResponse> handleInvalidParameterException(InvalidParameterException ex) {
        log.error("Unhandled Exception", ex);
        log.error(ex.getMessage());

        Throwable cause = ex.getCause();
        log.error("Unhandled exception::cause: " + (cause == null ? "<none>" : cause.getMessage()));
        if (cause != null) {
            log.error("cause::stack trace: ", cause);
        }

        AdapterServerResponse serverResponse = new AdapterServerResponse();
        serverResponse.setStatus(Status.FAILED);
        serverResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(serverResponse, HttpStatus.BAD_REQUEST);
    }


}