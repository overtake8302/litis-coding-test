package com.example.solution4.repository;

import com.example.solution4.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, DepartmentCustomRepository {
}
