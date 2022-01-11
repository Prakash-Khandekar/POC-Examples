package com.neosoft.poc.service;
 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.neosoft.poc.exception.UserNotFoundException;
import com.neosoft.poc.model.UserInfo;
import com.neosoft.poc.repo.IUserRepo;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo repo;
	@Override
	public String insertEmployee(UserInfo user) {
		int id = repo.save(user).getId();
		return "User Enrooled with Id: "+id;
	}
	
	@Override
	public String updateUserDetails(UserInfo user) throws UserNotFoundException {
		Optional<UserInfo> optional=repo.findById(user.getId());
	    if(optional.isPresent()) {
	    	repo.save(user);  // 
//	    	repo.findById(user.getId());
	    	return  user.getId()+" User is updated";
	    }
	    else {
	        throw new UserNotFoundException(user.getId()+" User not found ");    	
	    }
	
	}
	
	@Override
	public String deleteEmployeeByEno(int id) throws UserNotFoundException {
//		repo.deleteById(id);
//		return id+"  employee number  Employee deleted";
//		
		
		Optional<UserInfo> opt=repo.findById(id);
		  if(opt.isPresent()) {
			   repo.delete(opt.get());
			   return  id+" User deleted";
		  }
		  else {
		     throw new UserNotFoundException(id+" User not found ");	 
		       //throw new Exception(id+" Tourist not found ");	  

		  }
//		
	}

	@Override
	public List<UserInfo> getAll(String field) {
		return repo.findAll(Sort.by(Direction.ASC, field));
	}

	@Override
	public List<UserInfo> fechByPinCode(Long pinCode) {
		return repo.findByPinCode(pinCode)	;						
				}
	@Override
	public List<UserInfo> fetchAllData() {
		return repo.findAll();
	}

	@Override
	public List<UserInfo> fetchByNameOrSurnameOrPinCode(String fName, String lName, Long pinCode) {
		// TODO Auto-generated method stub
		return repo.findByFirstNameOrLastNameOrPinCode(fName, lName, pinCode);
	}

//	@Override
//	public String hardDelete(Integer id) {
//		//return repo.hardDelete(id);
//	}

	@Override
	public List<UserInfo> findByFName(String fName) {
		// TODO Auto-generated method stub
		return null;
	}

	



	
	
	 

	
}
