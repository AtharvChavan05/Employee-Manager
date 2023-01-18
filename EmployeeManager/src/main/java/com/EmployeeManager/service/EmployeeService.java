package com.EmployeeManager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManager.model.Employee;
import com.EmployeeManager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	
	public Employee findEmployeeById(Long  id) {
		return employeeRepo.findEmployeeById(id);
	}
}
