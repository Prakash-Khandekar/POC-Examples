package com.neosoft.POC2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.POC2.model.Student;
import com.neosoft.POC2.service.IStudentService;

@RestController
@RequestMapping("/neosoft/admin")
public class AdminController {
	@Autowired
	private IStudentService service;
	
	@GetMapping("getAdmin")
	public String getAdmin() {
		return "Admin";
	}
	
	@RequestMapping("/selectAll")
	public ResponseEntity<?> getAllData() {
		try {
			List<Student> list = service.fetchAll();
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/byId/{id}")
	public ResponseEntity<String> fetchById(@PathVariable Integer id) {
		try {
			String  msg = service.fetchByStudentId(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
