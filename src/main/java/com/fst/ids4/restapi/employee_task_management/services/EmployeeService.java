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

  public Employee findEmployeeById(String id) {
    return employeeRepository.findById(id).orElse(null);
  }

  public List<Employee> findEmployeeByFirstName(String firstName) {
    return employeeRepository.findByFirstName(firstName);
  }

  public List<Employee> findEmployeeByLastName(String lastName) {
    return employeeRepository.findByLastName(lastName);
  }

  public Employee saveEmployee(Employee employee) {
    //to ignore the null in the master Id (reference to master of the employee)
      Employee masterEmployee=employeeRepository.findByFirstName(employee.getMaster().getFirstName()).get(0);
      masterEmployee.setMaster(null);
      employee.setMaster(masterEmployee);

    return employeeRepository.save(employee);
  }

  public Employee updateEmployee(String id, Employee employee) {
    Employee newEmployee = employeeRepository.findById(id).orElse(null);
    if (newEmployee == null) {
      return null;
    }
    employee.setId(newEmployee.getId());
    // ... other properties
    return employeeRepository.save(employee);
   

  }

  public void deleteEmployee(String id) {
    employeeRepository.deleteById(id);
  }

}
