package com.neosoft.POC2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.POC2.exception.StudentNotFoundException;
import com.neosoft.POC2.model.Student;
import com.neosoft.POC2.repo.StudentRepo;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepo repo;

	@Override
	public String insertStudent(Student user) {
		Integer id = repo.save(user).getId();
		return "Student Id: " + id + " is allocated.";
	}

	@Override
	public List<Student> fetchAll() {
		return repo.findAll();

	}

	@Override
	public String fetchByStudentId(Integer id) throws StudentNotFoundException {
		// return repo.findById(id);
		Optional<Student> opt = repo.findById(id);
		if (opt.isPresent()) {
			return id + " Student available";
		} else {
			throw new StudentNotFoundException(id + " Student not found ");
		}
	}

}
