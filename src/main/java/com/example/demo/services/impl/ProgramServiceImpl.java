package com.example.demo.services.impl;

import com.example.demo.dto.ProgramDTO;
import com.example.demo.repository.ProgramRepository;
import com.example.demo.request.ProgramRequest;
import com.example.demo.services.ProgramService;
import com.example.demo.services.mapper.ProgramMapper;
import com.example.demo.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private ProgramMapper programMapper;

    @Override
    public Page<ProgramDTO> list(String search, ProgramRequest request, Pageable pageable) {
        return ResponseUtils.list(null, pageable, programRepository, programMapper);
    }
}
