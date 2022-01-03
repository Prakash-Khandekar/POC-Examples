package com.example.POC2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.POC2.beans.Student;
import com.example.POC2.repository.ProjectRepository;
import com.example.POC2.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired 
	StudentRepository studentRepository;
	

	@Autowired 
	ProjectRepository projecttRepository;
	
	public Student registerStudent(Student student){
		
		projecttRepository.saveAll(student.getProject());
		return studentRepository.save(student);
	}
	
    public ArrayList<Student> getAll(){
		
		return (ArrayList<Student>) studentRepository.findAll();
	}

    
    public Optional<Student> getStudentById(String id){
		
		return studentRepository.findById(id);
	}

}
