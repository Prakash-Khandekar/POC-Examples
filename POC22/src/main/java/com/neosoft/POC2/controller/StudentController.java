package com.neosoft.POC2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.POC2.model.Student;
import com.neosoft.POC2.service.IStudentService;

@RestController
@RequestMapping("/neosoft/student")
public class StudentController {

	@GetMapping("/getStudent")
	public String getStudent() {
		return "Student";
	}
	@Autowired
	private IStudentService service;
	
	@RequestMapping("/insert")
	public ResponseEntity<String> insertData(@RequestBody Student student) {
		try {
			String msg = service.insertStudent(student);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
