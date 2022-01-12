package com.neosoft.poc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neosoft.poc.model.UserInfo;
import com.neosoft.poc.repo.IUserRepo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	class PocUserExampleTestApplicationTests {

	@Autowired
	IUserRepo repo;
//	@Test
//	void contextLoads() {
//	}
	@Test
	@Order(1)
	public void testAddUser() {
	UserInfo user= new UserInfo();
	user.setFirstName("TESTCASE1");
	user.setLastName("CASE");
	user.setMoNo(98776);
	user.setPinCode(98877L);
	user.setDOB(Date.valueOf("2013-09-04"));
	user.setDOJ(Date.valueOf("2021-09-09"));
	repo.save(user);
	assertNotNull(repo.findById(24).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		List<UserInfo> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testSingleUserData() {
		UserInfo user1 = repo.findById(24).get();
		System.out.println(user1);
		assertEquals("RAO", user1.getLastName());
	}
	
	@Test
	@Order(4)
	public void testUpdateUser() {
		UserInfo user = repo.findById(65).get();
		user.setLastName("KHAN");
		repo.save(user);
		assertNotEquals("Khandekar", repo.findById(65).get().getLastName());
	}
	@Test
	@Order(5)
	public void testDelete() {
		repo.deleteById(94);
		assertThat(repo.existsById(94)).isFalse();
	}

}
