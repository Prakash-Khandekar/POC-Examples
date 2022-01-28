package com.neosoft.poc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.exception.UserNotFoundException;
import com.neosoft.poc.model.UserInfo;
import com.neosoft.poc.repo.IUserRepo;
import com.neosoft.poc.service.IUserService;

@RestController
public class UserEnrollment {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private IUserRepo repo;
	
	@RequestMapping("/message") // Simple API

	public String testMethod() {
		return "Hello Simple API";
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/addUser") // register new user
	public void save1UserDetails(@RequestBody UserInfo user) {
		try {
			String msg = service.insertEmployee(user);
			System.out.println(msg);
			//return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			//return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getById/{id}") // register new user
	public ResponseEntity<UserInfo> getStudentById(@PathVariable Integer id) throws UserNotFoundException{
		UserInfo user =repo.findById(id).orElseThrow(() -> new UserNotFoundException("User not exits:"+ id));
		return ResponseEntity.ok(user);
		
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PutMapping("/modify/{id}") // 2- Edit User base on user id
//	public ResponseEntity<String> modifyUser(@PathVariable Integer id ,@RequestBody UserInfo tourist) {
//		try {
//			System.out.println("Modify called");
//			String msg = service.updateUserDetails(tourist);
//			return new ResponseEntity<String>(msg, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/modify/{id}") // 2- Edit User base on user id
	public ResponseEntity<UserInfo> modifyUser(@PathVariable Integer id ,@RequestBody UserInfo userInfo) throws UserNotFoundException {
		UserInfo user = repo.findById(id).orElseThrow(() -> new UserNotFoundException("Student not exits"));	
		user.setFirstName(userInfo.getFirstName());
		user.setLastName(userInfo.getLastName());
		user.setPinCode(userInfo.getPinCode());
		user.setDOJ(userInfo.getDOJ());
		user.setDOB(userInfo.getDOB());
		user.setMoNo(userInfo.getMoNo());
		UserInfo userUpdate =repo.save(user);
		return  ResponseEntity.ok(userUpdate);
		
		
	}
	
	
//	@CrossOrigin(origins = "http://localhost:4200")	
//	@DeleteMapping("/delete/{id}") // soft deletion
//	public ResponseEntity<String> removeUser(@PathVariable("id") Integer id) {
//		try {
//			String msg = service.deleteEmployeeByEno(id);
//			return new ResponseEntity<String>(msg, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
//	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}") // soft deletion
	public ResponseEntity<Map<String,Boolean>> removeUser(@PathVariable("id") Integer id) throws UserNotFoundException {
		UserInfo user = repo.findById(id).orElseThrow(() -> new UserNotFoundException("Student not exits"));	
		repo.delete(user); 
		Map<String,Boolean> resp = new HashMap<>();
		resp.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(resp);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/sortByField/{field}") // 4. Sort User by DOB & Joining Date --- id,doj,dob
	public ResponseEntity<?> sortByField(@PathVariable("field") String field) {
		try {
			List<UserInfo> list = service.getAll(field);
			return new ResponseEntity<List<UserInfo>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/searchByPinCode/{pinCode}")
	public ResponseEntity<List<UserInfo>> getUserPinCode(@PathVariable("pinCode") Long name) {
		return new ResponseEntity<List<UserInfo>>(service.fechByPinCode(name), HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/selectAll")
	public ResponseEntity<List<UserInfo>> fetchData() {
		System.out.println("URL called");
		return new ResponseEntity<List<UserInfo>>(service.fetchAllData(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/search") 
	public ResponseEntity<List<UserInfo>> getUserByName(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("pinCode") Long pinCode) {
		System.out.println("Search URL called");
		System.out.println("FName " + firstName + " LName " + lastName + " PinCode " + pinCode);
		return new ResponseEntity<List<UserInfo>>(service.fetchByNameOrSurnameOrPinCode(firstName, lastName, pinCode),
				HttpStatus.OK);
	}

	
	@GetMapping("/hardDelete/{id}")
	public ResponseEntity<String> hardDeleteUser(@PathVariable Integer id) {
	//	String use = service.hardDelete(id);
		//System.out.println(use);
		String msg = id+" User deleted successfull";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}

//@GetMapping("/deleteUser/{id}")
//public   String deleteEmployee(@PathVariable Integer id) {
//	System.out.println(id);
//	//service.deleteEmployeeByEno(id);
//	return "User deleted successfull";
//}
