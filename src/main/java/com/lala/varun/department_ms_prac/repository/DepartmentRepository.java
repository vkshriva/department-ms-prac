package com.lala.varun.department_ms_prac.repository;

import com.lala.varun.department_ms_prac.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);
    Department findByDepartmentCode(String departmentCode);
}
