package com.cheese.core.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class CheeseListResponse {

    private int code;
    private String message;
    private List<Map<String, Object>> data;
    private LocalDateTime timestamp = LocalDateTime.now();

    @Builder
    public CheeseListResponse(int code, String message){
        this.code = code;
        this.message = message;
    }


}
