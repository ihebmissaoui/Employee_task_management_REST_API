package com.fst.ids4.restapi.employee_task_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fst.ids4.restapi.employee_task_management.models.Employee;
import com.fst.ids4.restapi.employee_task_management.services.*;
@RestController

@RequestMapping("/api/employees")
public class EmployeeController {
  
  private final EmployeeService employeeService;

  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
 

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.findAllEmployees();
  } 

  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable String id) {
    return employeeService.findEmployeeByFirstName(id);
  }

  @PostMapping
  public Employee addEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
  }
/* 
  @PutMapping("/{id}")
  public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
  }*/

  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable String id) {
    employeeService.deleteEmployee(id);
  }
}
