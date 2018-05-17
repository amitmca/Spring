package com.technicalkeeda.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "emp")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int employeeId;
	@Column
	 private String firstName;
	@Column
	 private String lastName;
	@Column
	 private Long age;

	
	public Employee() {
	}

	
	public Employee(int employeeId, String firstName, String lastName, Long age) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Employee Id:- " + getEmployeeId());
		str.append(" First Name:- " + getFirstName());
		str.append(" Last Name:- " + getLastName());
		str.append(" Age:- " + getAge());
		return str.toString();
	}
}