package com.stackroute.activitystream.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class User {

	@Id
	@Email
	private String emailid;
	
	
	private String status;
	@NotNull
	@NotBlank
	@NotEmpty
	private String firstName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String lastName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String phoneNumber;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailid() {
		return emailid;
	}
	public String getPassword() {
		return password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "User [emailid=" + emailid + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", phoneNumber=" + phoneNumber + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}