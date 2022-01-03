package com.example.POC2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.example.POC2.beans.Student;


@Repository
public  interface StudentRepository extends JpaRepository<Student, String> {

}
