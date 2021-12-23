package com.cheese.admin.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Response<T> {

    private int status;
    private String code;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();
    private T data;

}
