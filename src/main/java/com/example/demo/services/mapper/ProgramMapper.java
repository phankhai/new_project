package com.example.demo.services.mapper;

import com.example.demo.dto.ProgramDTO;
import com.example.demo.entity.ProgramEntity;
import com.example.demo.utils.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public interface ProgramMapper extends EntityMapper<ProgramDTO, ProgramEntity> {
}
