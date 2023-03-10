package com.EmployeeManager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManager.model.Employee;
import com.EmployeeManager.service.EmployeeService;

@RestController
@RequestMapping("employeemanager")
public class EmployeeController {
	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	@GetMapping("findAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees= service.findAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	@GetMapping("find/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id")Long id){
		Employee employee= service.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	@PostMapping("add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee newemployee= service.addEmployee(employee);
		return new ResponseEntity<>(newemployee,HttpStatus.CREATED);
	}
	@PutMapping("update")
	public ResponseEntity<Employee> updateEmployeeByID(@RequestBody Employee employee){
		Employee updateemployee= service.updateEmployee(employee);
		return new ResponseEntity<>(updateemployee,HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmployeeByID(@PathVariable("id")Long id){
		service.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
