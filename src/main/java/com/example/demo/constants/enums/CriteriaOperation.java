package com.example.demo.constants.enums;

public enum CriteriaOperation {
    SELECT,
    GROUP_BY,
    JOIN,
    JOIN_FETCH,
    EQUAL,
    EQUAL_TO_MANY,
    EQUAL_TO_ONE,
    LIKE,
    IS_NULL,
    IS_NOT_NULL,
    IN,
    LESS_THAN,
    LESS_THAN_OR_EQUAL_TO,
    GREATER_THAN,
    GREATER_THAN_OR_EQUAL_TO;

    private CriteriaOperation() {
    }
}
