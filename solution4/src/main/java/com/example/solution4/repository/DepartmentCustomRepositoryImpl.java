package com.example.solution4.repository;

import com.example.solution4.entity.Department;
import com.example.solution4.entity.QDepartment;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DepartmentCustomRepositoryImpl implements DepartmentCustomRepository {

    private final EntityManager entityManager;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Department> findAll() {

        QDepartment departmentA = QDepartment.department;
        QDepartment departmentB = QDepartment.department;

        List<Department> result = queryFactory
                .select(Projections.bean(Department.class,
                        departmentA.deptId,
                        departmentA.deptName,
                        departmentA.upDeptId))
                .from(departmentA)
                .leftJoin(departmentB).on(departmentA.deptId.eq(departmentB.upDeptId))
                .orderBy(departmentA.upDeptId.asc().nullsFirst())
                .fetch();

        return result;

    }
}
