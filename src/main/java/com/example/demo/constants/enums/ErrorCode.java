package com.example.demo.constants.enums;

/**
 * Created by nha.luong-cong on 29/01/2021.
 */
public enum ErrorCode {
    // For 2xx error code
    RRM_SUCCESS,

    // For 4xx error code
    RRM_BAD_REQUEST,
    RRM_CONSTRAINT_VIOLATION,
    RRM_ACCESS_DENIED,
    RRM_METHOD_NOT_ALLOWED,
    //// Custom codes
    RRM_METHOD_ARGUMENT_NOT_VALID,
    RRM_REQUEST_VALIDATION_FAILED,
    RRM_CONTENT_TYPE_UNSUPPORTED,
    RRM_MISSING_REQUEST_PARAM,
    RRM_ENDPOINT_NOT_FOUND,
    RRM_RESOURCE_NOT_FOUND,
    RRM_KAFKA_REPLY_ERROR,

    // For 5xx error code
    RRM_SERVER_ERROR,

    INVALID_INPUT,
    VALIDATE_FAILED

}
