package com.fst.ids4.restapi.employee_task_management.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fst.ids4.restapi.employee_task_management.models.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
}