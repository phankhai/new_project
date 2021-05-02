package com.example.demo.services.impl;

import com.example.demo.services.BaseService;
import com.example.demo.services.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("unchecked")
@Transactional(rollbackFor = Exception.class)
public class TecherServiceImpl implements TeacherService {



}
