package com.school.school_microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.school_microservice.dto.request.CreateSchoolRequestDto;
import com.school.school_microservice.model.School;
import com.school.school_microservice.repository.SchoolRepository;

@Service
public class SchoolService {
    
    @Autowired
    private SchoolRepository schoolRepository;

    public School createSchool(CreateSchoolRequestDto createSchoolRequestDto) {
        School school = new School();
        school.setName(createSchoolRequestDto.getName());
        return schoolRepository.save(school);
    }
    
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public School updateSchool(Long id, String name) {
        School school = schoolRepository.findById(id).orElse(null);
        if (school == null) {
            return null;
        }
        school.setName(name);
        return schoolRepository.save(school);
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}