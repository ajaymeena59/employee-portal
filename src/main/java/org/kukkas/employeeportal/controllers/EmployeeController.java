package org.kukkas.employeeportal.controllers;

import java.util.List;
import java.util.Optional;
import org.kukkas.employeeportal.entities.Employee;
import org.kukkas.employeeportal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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


@RestController
@RequestMapping("/apis")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		List<Employee> employees = null;
		
		try {
			
			employees = empService.getEmployees();
			
			if(employees.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} else {
			     return ResponseEntity.of(Optional.of(employees));	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empid") int empId) {
	
		try {
			
			Employee employee = empService.getEmployee(empId);
			
			if(employee == null ) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			} else {
				
				return ResponseEntity.ok().body(employee);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		
		try {
			
			Employee emp = empService.addEmployee(employee);
			
			return ResponseEntity.of(Optional.of(emp));
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	@PutMapping("/employees/{empid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("empid") int empId,@RequestBody Employee employee){
		
		try {
			
			Employee emp = empService.updateEmployee(empId, employee);
			
			if(emp==null) return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return ResponseEntity.ok().body(emp);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	@DeleteMapping("/employees/{empid}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") int empId){
		
		try {
			
			empService.deleteEmployee(empId);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}

}
