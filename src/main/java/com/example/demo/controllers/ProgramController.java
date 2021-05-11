package com.example.demo.controllers;

import com.example.demo.dto.ProgramDTO;
import com.example.demo.exception.CustomValidationException;
import com.example.demo.request.ProgramRequest;
import com.example.demo.services.ProgramService;
import com.example.demo.utils.PageableObject;
import com.example.demo.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "program")
public class ProgramController {

    @GetMapping("/list")
    public ResponseEntity<PageableObject<ProgramDTO>> list (@RequestParam(required = false, name="search") String search,
                                                            @ModelAttribute ProgramRequest request,
                                                            @PageableDefault Pageable pageable) throws CustomValidationException {
        return ResponseUtils.list(search, request, null, pageable, "/program/list", programService);
    }

    @Autowired
    private ProgramService programService;

}
