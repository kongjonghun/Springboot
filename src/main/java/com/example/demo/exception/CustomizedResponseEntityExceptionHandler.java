package com.example.demo.exception;

import com.example.demo.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.crypto.Data;
import java.util.Date;

//Exception Handler
@RestController
@ControllerAdvice // 모든 Controller 실행시 @ControllerAdvice에 해당하는 Bean이 사전에 실행
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // 일반적인 모든 Exception - Controller에서 Exception 발생시
    @ExceptionHandler(Exception.class) // 어떤 Exception?
    public final ResponseEntity<Object> handlerAllExceptions(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // UserNotFoundException
    @ExceptionHandler(UserNotFoundException.class) // 어떤 Exception?
    public final ResponseEntity<Object> handlerUserNotFoundExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    // 유효성 검사에 문제가 생겼을 경우,
    @Override // Overriding (ResponseEntityExceptionHandler 메소드)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        // exception 객체, request Header, status, request

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
