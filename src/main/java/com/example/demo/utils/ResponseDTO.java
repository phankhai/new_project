package com.example.demo.utils;

import com.example.demo.constants.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseDTO implements Serializable {
    protected ErrorCode code;
}
