package com.neosoft.POC2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.POC2.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
