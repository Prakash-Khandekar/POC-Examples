package com.jwt.department.service.repository;

import com.jwt.department.service.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    Department findByDepartmentId(String departmentId);
}
