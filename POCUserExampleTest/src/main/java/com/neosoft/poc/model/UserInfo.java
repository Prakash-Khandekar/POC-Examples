package com.neosoft.poc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@SQLDelete(sql = "UPDATE USER_INFO SET STATUS='deleted' WHERE id=?")  //soft deletion
//@Where(clause = "STATUS  <> 'deleted' ")  // implicit condition on select operations
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private Long pinCode;
	private Date DOJ;
	private Date DOB;
	private Integer moNo; // Need to take LONG
	private String status="active";  // default value to be inserted/updated

}
