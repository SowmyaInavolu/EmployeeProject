package com.employee.service.impl;

import java.lang.reflect.Field;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.AddressService;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	

	AddressService service = new AddressService();

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public boolean deleteEmployee(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.delete(employee.get());
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Employee updateEmployee(long id, Employee updatedEmployee) {
		Employee oldEmployeeData = employeeRepository.findById(id).orElse(null);
		if (oldEmployeeData != null) {
			oldEmployeeData.setEmployeeName(updatedEmployee.getEmployeeName());
			oldEmployeeData.setDesignation(updatedEmployee.getDesignation());
			oldEmployeeData.setSalary(updatedEmployee.getSalary());
		}
		employeeRepository.save(oldEmployeeData);
		return oldEmployeeData;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	
	public String getEmployeeAddress() {
		return service.getEmployeeAddress();
	}
	

}
