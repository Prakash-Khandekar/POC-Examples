package com.example.POC2.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;


@Data
@Entity
@Table(name="Project_poc2")
public class Project {

	@Id
	@NotNull
	@Column(name="project_id",length = 32)
	private String projectId;
	
    @Column(name="projectName",length = 32)
	private String projectName;
    
   @Column(name="duration",length = 32)
    private String duration;
   
  
	
	
}

