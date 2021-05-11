package com.example.demo.services;

import com.example.demo.dto.ProgramDTO;
import com.example.demo.request.ProgramRequest;
import org.springframework.stereotype.Component;

@Component
public interface ProgramService extends BaseService<ProgramDTO, ProgramRequest, ProgramDTO> {
}
