package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "giaovien")
public class TeacherEntity {

    @Id
    @Column(name = "MAGV")
    private String ma;

    @Column(name = "DIACHI")
    private String diachi;

    @Column(name = "HOTEN")
    private String hoten;

    @Column(name = "LUONG")
    private Float luong;

    @Column(name = "NGSINH")
    private Date ngaysinh;

    @Column(name = "PHAI")
    private String phai;
}

