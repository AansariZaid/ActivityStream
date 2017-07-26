package com.stackroute.activitystream.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class User extends BaseDomain {

	@Id
	@Email
	private String emailid;
	
	@NotNull(message = "Status Cannot be Null")
	@NotBlank(message = "Status Cannot be Blank")
	@NotEmpty(message = "Status Cannot be Empty")
	private String status;
	
	@NotNull(message = "First Name Cannot be Null")
	@NotBlank(message = "First Name Cannot be Blank")
	@NotEmpty(message = "First Name Cannot be Empty")
	private String firstName;
	
	@NotNull(message = "Last Name Cannot be Null")
	@NotBlank(message = "Last Name Cannot be Blank")
	@NotEmpty(message = "Last Name Cannot be Empty")
	private String lastName;
	
	@NotNull(message = "Password Cannot be Null")
	@NotBlank(message = "Password Cannot be Blank")
	@NotEmpty(message = "Password Cannot be Empty")
	private String password;
	
	@NotNull(message = "Contact Number Cannot be Null")
	@NotBlank(message = "Contact Number Cannot be Blank")
	@NotEmpty(message = "Contact Number Cannot be Empty")
	@Pattern(regexp = "^\\d{10}")
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