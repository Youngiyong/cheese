package com.cheese.core.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheeseSuccessResponse {

    private int code;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    @Builder
    public CheeseSuccessResponse(int code, String message){
        this.code = code;
        this.message = message;
    }


}
