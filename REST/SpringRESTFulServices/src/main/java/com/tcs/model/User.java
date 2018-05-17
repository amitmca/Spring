package com.tcs.model;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int user_id;
	String username;
	String password;
    String firstName;
   	String lastName;
    String phone;
    String emailId;
    private boolean valid;
    
    public User(){
    	
    }
    
    @JsonCreator
    public User(@JsonProperty("user_id") int user_id, @JsonProperty("username") String username,
      @JsonProperty("password") String password, @JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("phone") String phone,@JsonProperty("phone") String emailId
    ) {
     this.user_id = user_id;
     this.username = username;
     this.firstName = firstName;
     this.lastName = lastName;
     this.phone = phone;
     this.emailId = emailId; 
    }
    
    @Transient
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

    @Override
    public String toString() {
        return "Id: " + user_id + "; fname : " + firstName + "' phone : " + phone + "; emailId: " + emailId;
    }
}
