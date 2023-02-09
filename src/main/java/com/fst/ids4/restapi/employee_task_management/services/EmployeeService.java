package com.fst.ids4.restapi.employee_task_management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fst.ids4.restapi.employee_task_management.models.Employee;
import com.fst.ids4.restapi.employee_task_management.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> findAllEmployees() {
    return employeeRepository.findAll();
  }

  public Employee findEmployeeByFirstName(String firstName) {
    return employeeRepository.findByFirstName(firstName);
  }

  public List<Employee> findEmployeeByLastName(String lastName) {
    return employeeRepository.findByLastName(lastName);
  }

  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void deleteEmployee(String id) {
    employeeRepository.deleteById(id);
  }

}
