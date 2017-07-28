package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SubscribeCircle {

	@Id
	int subscriptionId;

	@NotNull
	int circleId;

	@NotNull
	String emailId;
	
	@NotNull
	String status;
	
	@NotNull
	Date subcriptionDate;

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public int getCircleId() {
		return circleId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public Date getSubcriptionDate() {
		return subcriptionDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubcriptionDate(Date subcriptionDate) {
		this.subcriptionDate = subcriptionDate;
	}

	@Override
	public String toString() {
		return "SubscribeCircle [subscriptionId=" + subscriptionId + ", circleId=" + circleId + ", emailId=" + emailId
				+ ", status=" + status + ", subcriptionDate=" + subcriptionDate + "]";
	}
}
