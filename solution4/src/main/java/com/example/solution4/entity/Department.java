package com.example.solution4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private Integer deptId;

    @Column(name = "DEPT_NAME")
    private String deptName;

    @Column(name = "UP_DEPT_ID")
    private Integer upDeptId;
}
