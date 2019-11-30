package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="employee")
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable
{
    private static final long serialVersionUID = 1L;
     
    public Employee(Integer id, String firstname, String lastname, String email) {
        super();
        this.employeeid = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
 
    public Employee() {
    }
 
    @Id
	@Column(name="employeeid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer employeeid;
 
    public Integer getemployeeid() {
		return employeeid;
	}

	public void setemployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "first name must not be empty")
	@Column(name = "firstname")
    private String firstname;
 
    @NotEmpty(message = "last name must not be empty")
    @Column(name = "lastname")
    private String lastname;
 
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    @Column(name = "email")
    private String email;
     
    //Removed setter/getter for readability
}