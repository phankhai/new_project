package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "program")
public class ProgramEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long programId;

    private String title;
    private String thumbNail;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

}

