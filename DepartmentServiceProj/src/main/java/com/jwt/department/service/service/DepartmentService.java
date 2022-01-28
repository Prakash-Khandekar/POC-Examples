package com.jwt.department.service.service;

import com.jwt.department.service.entity.Department;
import com.jwt.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of the DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(String departmentId) {
        log.info("Inside findDepartmentById method of the DepartmentService");
        //return departmentRepository.findByDepartmentId(departmentId);
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
