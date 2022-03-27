package com.example.demo.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok : 자주 사용하는 메소드 자동 생성(ex 기본생성자, getter, setter..)
@Data
@AllArgsConstructor // 모든 필드에 대해 파라미터로 갖는 생성자 추가 @NoArgsConstructor : 매개변수없는 기본생성자 생성 가능
public class HelloWorldBean {
    private String message;
    
    //// lombok이 자동 생성
    // 1. getter, setter
    /* public String getMessage() {
        return message;}
    public void setMessage(String message) {
        this.message = message;}*/
    // 2. 기본 생성자
    /*public HelloWorldBean(String message){
        this.message = message;}*/

}
