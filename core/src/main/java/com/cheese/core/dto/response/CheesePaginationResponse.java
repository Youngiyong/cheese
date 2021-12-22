package com.cheese.core.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class CheesePaginationResponse {

    private int code;
    private String message;
    private Map<String, Object> data;
    private LocalDateTime timestamp = LocalDateTime.now();

    @Builder
    public CheesePaginationResponse(int code, String message){
        this.code = code;
        this.message = message;
    }


}
