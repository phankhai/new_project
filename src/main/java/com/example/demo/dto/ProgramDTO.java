package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgramDTO extends BaseDTO {

    private Long programId;

    private String title;
    private String thumbNail;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

}
