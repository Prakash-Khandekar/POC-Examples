package com.example.POC2.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.POC2.beans.AuthenticationRequest;
import com.example.POC2.beans.Student;
import com.example.POC2.models.AuthenticationResponse;
import com.example.POC2.service.MyUserDetailsService;
import com.example.POC2.service.StudentService;
import com.example.POC2.util.JWTUtil;

import antlr.collections.List;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		
		  try { authenticationManager.authenticate( new
		  UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
		  authenticationRequest.getPassword()) ); } 
		  catch (BadCredentialsException e) {
		  throw new Exception("Incorrect username or password", e); }
		 


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return new ResponseEntity<>(jwt,HttpStatus.OK) ;
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/registerStudent")
	public ResponseEntity<Student> registerStudent(@Valid @RequestBody Student student) throws Exception
	
	{
		
		Student savedStudent=service.registerStudent(student);
		if(savedStudent==null)
		{
			throw new Exception("error");
		}
		return new ResponseEntity<>(savedStudent,HttpStatus.OK);
	}

	
	@RequestMapping(method=RequestMethod.GET,path="/getAllStudent")
	public ResponseEntity<ArrayList<Student>> getAllStudent()
	
	{
		ArrayList<Student> listStudent=service.getAll();
		if(listStudent.isEmpty())
		{
			
		}
		return new ResponseEntity<>(listStudent,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/getStudentByID")
	public ResponseEntity<Optional<Student>> getStudentByID(@RequestParam("id") String id)
	
	{
		Optional<Student> student=service.getStudentById(id);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
}
