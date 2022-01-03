package com.neosoft.POC2.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "PROJ_INFO")
@Entity
public class Project {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id	
	private Integer id;
	private String projName;
	private Long duration;
}
