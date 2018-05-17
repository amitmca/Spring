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
	private int employee_id;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private Long age;

	@JsonCreator
	public Employee(@JsonProperty("employeeId") int employeeId,
			@JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName,
			@JsonProperty("age") Long age) {
		this.employee_id = employeeId;
		this.first_name = firstName;
		this.last_name = lastName;
		this.age = age;
	}

	public Employee() {
	}

	public int getEmployeeId() {
		return employee_id;
	}

	public void setEmployeeId(int employeeId) {
		this.employee_id = employeeId;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
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