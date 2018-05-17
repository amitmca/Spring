package com.tcs.domain;


/**
 * @author Amit Bhalerao
 *
 */
public class User{
	
	private Long userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String emailId;
	private boolean valid;

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFullName(){
		return (this.firstName + " " + this.lastName);
	}
	
    public boolean isValid() {
       return valid;
    }
    
    public void setValid(boolean valid) {
	    this.valid = valid;
	}
}
