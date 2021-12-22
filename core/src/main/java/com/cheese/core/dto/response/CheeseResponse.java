package com.cheese.core.dto.response;


import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class CheeseResponse {

    private int code;
    private String message;
    private Map<String, Object> data;
    private LocalDateTime timestamp = LocalDateTime.now();

    @Builder
    public CheeseResponse(int code, String message, Map<String, Object> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
