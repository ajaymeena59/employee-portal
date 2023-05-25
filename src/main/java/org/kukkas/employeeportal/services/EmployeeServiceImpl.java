package org.kukkas.employeeportal.services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.kukkas.employeeportal.entities.Employee;
import org.kukkas.employeeportal.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityNotFoundException;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> employees = empRepo.findAll();
		
		System.out.println(employees.isEmpty());
		
		return employees;
	}

	@Override
	public Employee getEmployee(int empId) {
		
		try {
			Employee employee = empRepo.getReferenceById(empId);
					
			System.out.println(employee.getEmpName());
			
			return employee;
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee emp = empRepo.saveAndFlush(employee);
		
		return emp;
	}

	@Override
	public Employee updateEmployee(int empId, Employee employee) {
		
       Optional<Employee> optional = empRepo.findById(empId);
       try {
		Employee emp = optional.get();
		   
		   emp.setEmpName(employee.getEmpName());
		   emp.setEmpPhone(employee.getEmpPhone());
		   emp.setEmpEmail(employee.getEmpEmail());
		   emp.setDpPath(employee.getDpPath());
		   emp.setEmpProfession(employee.getEmpProfession());
		   emp.setEmpYOP(employee.getEmpYOP());
		   emp.setEmpAddress(employee.getEmpAddress());
		   
		   Employee updatedEmp = empRepo.saveAndFlush(emp);
			
			return updatedEmp;
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}

	@Override
	public void deleteEmployee(int empId) {
		
		try {
			
			empRepo.deleteById(empId);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
