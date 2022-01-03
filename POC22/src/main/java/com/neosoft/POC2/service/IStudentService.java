package com.neosoft.POC2.service;

import java.util.List;

import com.neosoft.POC2.exception.StudentNotFoundException;
import com.neosoft.POC2.model.Student;

public interface IStudentService {
	public String insertStudent(Student user);
	public List<Student> fetchAll();
	public String fetchByStudentId(Integer id) throws StudentNotFoundException;

}
