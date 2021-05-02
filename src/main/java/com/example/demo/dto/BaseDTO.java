package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDTO implements Serializable {
    private UUID id;
    @JsonSetter(nulls = Nulls.SKIP)
    private UUID languageId = UUID.fromString("8559d932-eb46-49fb-9203-9da3e3354321");//vi
    private String token;
    private String error;
//    @JsonSetter(nulls = Nulls.SKIP)
//    private String device = Device.WEB.name();
}
