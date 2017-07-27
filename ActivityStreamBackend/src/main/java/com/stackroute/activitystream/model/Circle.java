package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Circle {
	
	@Id
	int Circleid;
	
	@NotNull
	String circleName;
	
	String Description;
	
	@NotNull
	String circleOwner;
	
	@NotNull
	Date creationDate;	

	

	public String getCircleOwner() {
		return circleOwner;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCircleOwner(String circleOwner) {
		this.circleOwner = circleOwner;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

	public int getCircleid() {
		return Circleid;
	}

	public void setCircleid(int circleid) {
		Circleid = circleid;
	}

	public String getCircleName() {
		return circleName;
	}

	public String getDescription() {
		return Description;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Circle [Circleid=" + Circleid + ", circleName=" + circleName + ", Description=" + Description
				+ ", circleOwner=" + circleOwner + ", creationDate=" + creationDate + "]";
	}
	
	
	

}
