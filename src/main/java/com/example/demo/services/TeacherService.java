package com.example.demo.services;

import com.example.demo.dto.TeacherDTO;
import com.example.demo.request.CampaignRequest;
import org.springframework.stereotype.Component;

@Component
public interface TeacherService extends BaseService<TeacherDTO, CampaignRequest, TeacherDTO> {
}
