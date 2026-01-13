package com.school.school_microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.school_microservice.dto.request.CreateSchoolRequestDto;
import com.school.school_microservice.model.School;
import com.school.school_microservice.service.SchoolService;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<?> createSchool(@RequestBody CreateSchoolRequestDto createSchoolRequestDto) {
        try {
            School school = schoolService.createSchool(createSchoolRequestDto);
            return ResponseEntity.ok(school);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllSchools() {
        try {
            List<School> schools = schoolService.getAllSchools();
            return ResponseEntity.ok(schools);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable Long id) {
        try {
            School school = schoolService.getSchoolById(id);
            return ResponseEntity.ok(school);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSchool(@PathVariable Long id, @RequestBody String name) {
        try {
            School school = schoolService.updateSchool(id, name);
            return ResponseEntity.ok(school);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable Long id) {
        try {
            schoolService.deleteSchool(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }    
}
