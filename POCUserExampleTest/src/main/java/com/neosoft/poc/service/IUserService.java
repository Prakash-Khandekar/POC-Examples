package com.neosoft.poc.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.neosoft.poc.exception.UserNotFoundException;
import com.neosoft.poc.model.UserInfo;

public interface IUserService {
	public String insertEmployee(UserInfo user);

	public String updateUserDetails(UserInfo user) throws UserNotFoundException;

	public String deleteEmployeeByEno(int eno) throws UserNotFoundException;

	public List<UserInfo> getAll(String field);

	public List<UserInfo> fechByPinCode(Long pinCode);

	public List<UserInfo> fetchByNameOrSurnameOrPinCode(String fName,String lName, Long pinCode); 
	
	//public String hardDelete(Integer id); 
	
	public List<UserInfo> findByFName(String fName);


}
