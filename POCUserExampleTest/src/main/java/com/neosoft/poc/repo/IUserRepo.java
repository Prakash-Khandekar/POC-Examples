package com.neosoft.poc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoft.poc.model.UserInfo;


public interface IUserRepo extends JpaRepository<UserInfo, Integer> {
	public List<UserInfo> findByFirstNameOrLastNameOrPinCode(String fName, String lName, Long pinCode);
	public List<UserInfo> findByPinCode(Long pinCode);
	//@Query("DELETE FROM USER_INFO u WHERE u.ID = ?1")
   // public String hardDelete(Integer id);
 

}
