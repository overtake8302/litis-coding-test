package com.example.solution4.repository;

import com.example.solution4.entity.Department;

import java.util.List;

public interface DepartmentCustomRepository {

    List<Department> findAll();
}
