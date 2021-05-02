package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO extends BaseDTO {

    private String ma;
    private String diachi;
    private String hoten;
    private Float luong;
    private String ngaysinh;
    private String phai;

}
