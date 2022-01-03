package com.example.POC2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.POC2.beans.Project;

@Repository
public  interface ProjectRepository extends JpaRepository<Project, String> {

}
