package com.example.solution4.controller;

import com.example.solution4.entity.Department;
import com.example.solution4.entity.DepartmentDto;
import com.example.solution4.service.SolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SolutionController {

    private final SolutionService solutionService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {

        List<DepartmentDto> departments = solutionService.findAll();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}
