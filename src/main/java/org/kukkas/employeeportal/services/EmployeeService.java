package org.kukkas.employeeportal.services;

import java.util.List;
import org.kukkas.employeeportal.entities.Employee;

public interface EmployeeService {

 	public List<Employee> getEmployees();

	public Employee getEmployee(int empId);

	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(int empId, Employee employee);

	public void deleteEmployee(int empId);

	
	
}
