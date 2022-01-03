package com.example.POC2.beans;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;


@Data
@Entity
@Table(name="Student_POC2")
public class Student {

	@Id
	@NotNull
	@Column(name="studentId",length = 32)
	private String studentId;
	
    @Size(min=2,message="name should have atleast 2 character")
    @Column(name="firstName",length = 32)
	private String firstName;
    
    @Size(min=2,message="Surname should have atleast 2 character")
    @Column(name="surName",length = 32)
	private String surName;
    
    @Size(min=10,max=10,message="Surname should have atleast 2 character")
    @Column(name="mobileNo",length = 20)
   	private String mobileNO;
    
    @Column(name="email",length = 32)
   	private String email;
    
    
    @OneToMany
    private Set<Project> project;
    
   
	
	
}

