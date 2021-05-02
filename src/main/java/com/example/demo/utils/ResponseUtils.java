package com.example.demo.utils;

import com.example.demo.dto.BaseDTO;
import com.example.demo.common.rest.PageResponseDTO;
import com.example.demo.exception.CustomValidationException;
import com.example.demo.services.BaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

import java.io.Serializable;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ResponseUtils {

    private static final Logger logger = LogManager.getLogger(ResponseUtils.class);

    public static <R, T>ResponseEntity<R> ok (Page<T> page, String baseUrl) {
        if (page != null) {
            HttpHeaders headers = PaginationUtils.generatePaginationHttpHeaders(page, baseUrl);
            return new ResponseEntity<>((R) PageResponseDTO.wrap(page), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static <D extends BaseDTO, V extends Validator, S extends BaseService, R extends Serializable> ResponseEntity<PageableObject<D>> list(String search, R request, V validator, Pageable pageable, String baseUrl, S service) throws CustomValidationException {
        if (validator != null) {
            BindException errors = new BindException(request, "request");
            validator.validate(request, errors);
            if (errors.hasErrors()) {
                throw new CustomValidationException(errors);
            }
        }
        Page<D> page = Page.empty();
        if (service != null) {
            page = service.list(search, request, pageable);
        }
        return ResponseUtils.ok(page, baseUrl);
    }

}
