package org.kukkas.employeeportal.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_phone")
	private String empPhone;
	
	@Column(name="emp_email")
	private String empEmail;
	
	@Column(name="emp_profession")
	private String empProfession;
	
	@Column(name = "emp_yop")
	private int empYOP;
	
	@Column(name="dp_path")
	private String dpPath;
	
	@JoinColumn(name= "emp_address")
	@OneToOne(cascade = CascadeType.ALL)
	private Address empAddress;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpProfession() {
		return empProfession;
	}

	public void setEmpProfession(String empProfession) {
		this.empProfession = empProfession;
	}

	public int getEmpYOP() {
		return empYOP;
	}

	public void setEmpYOP(int empYOP) {
		this.empYOP = empYOP;
	}

	public String getDpPath() {
		return dpPath;
	}

	public void setDpPath(String dpPath) {
		this.dpPath = dpPath;
	}

	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone + ", empEmail=" + empEmail
				+ ", empProfession=" + empProfession + ", empYOP=" + empYOP + ", dpPath=" + dpPath
				+ ", empAddress=" + empAddress + "]";
	}
	
}
