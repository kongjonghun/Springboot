package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// HTTP Status Code
// 2xx -> Ok
// 4xx -> Client
// 5xx -> Server

@ResponseStatus(HttpStatus.NOT_FOUND) // 500 -> 404
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message); // 부모클래스 반환
    }
}
