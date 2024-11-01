package com.example.solution4.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DepartmentDto {

    private Integer deptId;

    private String deptName;

    private Integer upDeptId;

    private List<DepartmentDto> children = new ArrayList<>();

    public DepartmentDto (Department department) {
        this.deptId = department.getDeptId();
        this.deptName = department.getDeptName();
        this.upDeptId = department.getUpDeptId();
    }
}
