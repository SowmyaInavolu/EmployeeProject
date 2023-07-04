package com.employee.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/getAllEmployeesById")
	public Optional<Employee> getAllEmployeesById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public boolean deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
	}
	
	@PatchMapping("/updateEmployee/{id}")
	 public  Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee){
		
		return employeeService.updateEmployee(id,updatedEmployee);
	}
	

	
}
