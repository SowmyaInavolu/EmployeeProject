package com.employee.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.employee.model.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
    Employee updateEmployee(long id ,Employee emp);
    boolean deleteEmployee(long id);

}
