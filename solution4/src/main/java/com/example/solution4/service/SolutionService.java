package com.example.solution4.service;

import com.example.solution4.entity.Department;
import com.example.solution4.entity.DepartmentDto;
import com.example.solution4.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolutionService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> findAll() {
        List<Department> departments = departmentRepository.findAll();

        Map<Integer, DepartmentDto> departmentMap = departments.stream()
                .collect(Collectors.toMap(Department::getDeptId, DepartmentDto::new));

        List<DepartmentDto> roots = new ArrayList<>();

        for (Department department : departments) {
            DepartmentDto dto = departmentMap.get(department.getDeptId());

            if (department.getUpDeptId() == null) {
                roots.add(dto);
            } else {
                DepartmentDto parentDto = departmentMap.get(department.getUpDeptId());
                parentDto.getChildren().add(dto);
            }
        }

        return roots;
    }
}
