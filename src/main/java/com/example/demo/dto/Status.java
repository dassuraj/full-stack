package com.example.demo.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Status {
    private String message;
    private Object data;
    private HttpStatus status;
}
