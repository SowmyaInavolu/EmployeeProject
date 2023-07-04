package com.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.impl.EmployeeServiceImplementation;

import mockit.Expectations;
import mockit.Mocked;

public class EmployeeServiceTest {

	@Mocked
	private EmployeeRepository employeeRepository;

	private EmployeeServiceImplementation employeeServiceImplementation;

	@BeforeEach
	public void test() {
		employeeServiceImplementation = new EmployeeServiceImplementation();
		employeeServiceImplementation.setEmployeeRepository(employeeRepository);
	}

	@Test
	public void testGetAllEmployees(@Mocked AddressService addressService) {

		List<Employee> employees = new ArrayList<>();
		Optional<Employee> employee = Optional.of(new Employee(1, "S", "T", 100l));
		new Expectations() {
			{
//				employeeRepository.findAll();
//				result = employees;

				addressService.getEmployeeAddress();
				result = "divakar";
				
				

			}
		};

//		assertEquals(0, employeeServiceImplementation.getAllEmployees().size());
//		assertEquals(1L, employeeServiceImplementation.getEmployeeById(1l).get().getEmployeeId());
//	
		assertEquals("divakar", employeeServiceImplementation.getEmployeeAddress());
	}
	
	@Test
	public void testForGetAllEmployees() {

		new Expectations() {
			{
//				employeeRepository.findAll();
//				result = employees;
                AddressService addressService = new AddressService();
				addressService.getEmployeeAddress();
				result = "divakar";
				
				

			}
		};

//		assertEquals(0, employeeServiceImplementation.getAllEmployees().size());
//		assertEquals(1L, employeeServiceImplementation.getEmployeeById(1l).get().getEmployeeId());
//	
		assertEquals("divakar", employeeServiceImplementation.getEmployeeAddress());
	}


	@Test
	public void testCreateAllEmployees(@Mocked EmployeeRepository employeeRepository) {

		Employee emp = new Employee(2, "Sai", "Trainee", 1000L);

		new Expectations() {
			{
				employeeRepository.save(emp);
				result = emp;
			}

		};
		assertEquals(emp, employeeServiceImplementation.createEmployee(emp));

	}

	@Test
	public void testDeleteEmployee(@Mocked EmployeeRepository employeeRepository) {

		Employee emp = new Employee(2, "Sai", "Trainee", 1000L);
		new Expectations() {
			{
				employeeRepository.findById(emp.getEmployeeId());
				result = Optional.of(emp);
			}
		};
		assertEquals(true, employeeServiceImplementation.deleteEmployee(emp.getEmployeeId()));

	}

	@Test
	public void testUpdateEmployee(@Mocked EmployeeRepository employeeRepository) {
		Employee employeeData = new Employee(3, "Sowmya", "SE", 10000l);
		Employee updatedEmployeeData = new Employee(3, "Sai", "SE", 12000l);

		new Expectations() {
			{
				employeeRepository.findById(employeeData.getEmployeeId());
				result = Optional.of(employeeData);

				employeeRepository.save(updatedEmployeeData);
				result = updatedEmployeeData;

			}
		};
		assertEquals(updatedEmployeeData.getEmployeeName(), employeeServiceImplementation
				.updateEmployee(employeeData.getEmployeeId(), updatedEmployeeData).getEmployeeName());
	}
}
