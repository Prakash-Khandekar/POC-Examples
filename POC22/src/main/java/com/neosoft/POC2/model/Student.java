package com.neosoft.POC2.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Table(name="STUDENT_INFO")
@Entity
@Data
public class Student {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id	
	private Integer id;
	@Column(length = 20,unique = true,nullable = false)
	private String uname;
	@Column(length = 150,nullable = false)
	private String  pwd;
	@Column(length = 20,nullable = false)
	private String email;
	private Boolean  status=true;
	private String firstName;
	private String lastName;
	private Long mobileNumber;
	
	@OneToMany
    private Set<Project> project ;
	}
