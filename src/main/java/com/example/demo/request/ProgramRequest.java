package com.example.demo.request;

import com.example.demo.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class ProgramRequest extends BaseDTO {
    private Long programId;

    private String title;
    private String thumbNail;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
}
