package com.lala.varun.department_ms_prac.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String departmentName;
    private String departmentDescription;
    private  String departmentCode;

}
