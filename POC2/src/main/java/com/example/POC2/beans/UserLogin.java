package com.example.POC2.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="UserLogin")
public class UserLogin {
	
	@Id
	@NotNull
	@Column(name="userId",length = 32)
	String userId;
	
	@NotNull
	@Column(name="userName",length = 32)
	String userName;
	
	@NotNull
	@Column(name="password",length = 32)
	String password;

}
