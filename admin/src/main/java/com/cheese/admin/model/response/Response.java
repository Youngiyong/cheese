package com.cheese.admin.model.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Response<T> {

    private int status;
    private String code;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();
    private T data;

}
