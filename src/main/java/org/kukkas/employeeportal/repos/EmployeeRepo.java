package org.kukkas.employeeportal.repos;

import org.kukkas.employeeportal.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	

}
