package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "myusers")
@NamedQueries(value = {
	    @NamedQuery(name = "User.findByLastname", query = "select u from User u where u.lastname = ?1"),
	    @NamedQuery(name = "User.findByAgeBetween", query = "select u from User u where u.age between ?1 and ?2")
	})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "first_name", nullable = false)
	private String firstname;
	@Column(name = "last_name", nullable = false)
	private String lastname;
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	@Column(name = "age", nullable = false)
	private int age;
	@Column(name = "active", nullable = false)
	private int active;
	
	public User() {
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", startDate=" + startDate
				+ ", age=" + age + ", active=" + active + "]";
	}

	public User(long id, String firstname, String lastname, Date startDate, int age, int active) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.startDate = startDate;
		this.age = age;
		this.active = active;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}