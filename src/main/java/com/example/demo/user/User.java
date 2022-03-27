package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data // lombok : 필드에 해당하는 필수적 메소드들 자동 생성(생성자, getter setter, toString 등)
@AllArgsConstructor
//@JsonIgnoreProperties(value={"password"})
@JsonFilter("UserInfo")
public class User {
    private Integer id;

    // 제약조건
    @Size(min=2, message = "Name은 2글자 이상 입력해 주세요.") //최소 길이 지정
    private String name;

    @Past // 미래 데이터 사용 X
    private Date joinDate;

    private String password;

    private String ssn;
}
