package com.EmployeeManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	Employee findEmployeeById(Long id);

}
