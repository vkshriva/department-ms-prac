package com.lala.varun.department_ms_prac.mapper;

import com.lala.varun.department_ms_prac.dto.DepartmentDto;
import com.lala.varun.department_ms_prac.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto toDto(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDto dto = new DepartmentDto();
        dto.setId(department.getId());
        dto.setDepartmentName(department.getDepartmentName());
        dto.setDepartmentDescription(department.getDepartmentDescription());
        dto.setDepartmentCode(department.getDepartmentCode());
        return dto;
    }

    public static Department toEntity(DepartmentDto dto) {
        if (dto == null) {
            return null;
        }
        Department department = new Department();
        department.setId(dto.getId());
        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentDescription(dto.getDepartmentDescription());
        department.setDepartmentCode(dto.getDepartmentCode());
        return department;
    }

}
