package com.lala.varun.department_ms_prac.service;

import com.lala.varun.department_ms_prac.dto.DepartmentDto;
import com.lala.varun.department_ms_prac.entity.Department;
import com.lala.varun.department_ms_prac.mapper.DepartmentMapper;
import com.lala.varun.department_ms_prac.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private  DepartmentRepository departmentRepository;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        Department department = DepartmentMapper.toEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.toDto(savedDepartment);

    }
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return DepartmentMapper.toDto(department);
    }

}
