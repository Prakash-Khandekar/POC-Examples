package com.jwt.user.service.controller;

import com.jwt.user.service.VO.ResponseTemplateVO;
import com.jwt.user.service.entity.User;
import com.jwt.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		try {
			log.info("Inside saveUser method of the UserController");
			return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserWithDepartment(@PathVariable("id") String userId) {
		try {
			log.info("Inside getUserWithDepartment method of the UserController");
			return new ResponseEntity<ResponseTemplateVO>(userService.getUserWithDepartment(userId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
