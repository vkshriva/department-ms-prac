package com.lala.varun.department_ms_prac.controller;

import com.lala.varun.department_ms_prac.dto.DepartmentDto;
import com.lala.varun.department_ms_prac.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**This has to added wherever u want updated properties from spring config server via actuautor endpoint
//This is used to refresh the properties without restarting the application
 **/
@RefreshScope
@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;

    @Value("${dept.message}")
    private String welcomeMessage;

    @Value("${server.port}")
    private String port;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);

    }
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        if (departmentDto != null) {
        departmentDto.setDepartmentName(departmentDto.getDepartmentName()+" "+ welcomeMessage + " from port " + port);
            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
