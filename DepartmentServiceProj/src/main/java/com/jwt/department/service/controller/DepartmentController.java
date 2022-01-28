package com.jwt.department.service.controller;

import com.jwt.department.service.entity.Department;
import com.jwt.department.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
		try {
			log.info("Inside saveDepartment method of the DepartmentController");
			return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findDepartmentById(@PathVariable("id") String departmentId) {
		try {
			log.info("Inside findDepartmentById method of the DepartmentController");
			return new ResponseEntity<Department>(departmentService.findDepartmentById(departmentId),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
