package com.LakshareEventManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerEnquireList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	private String name;
	
	private String email;
	private String mobile;
	private String events;
	private String eventDate;
	private String eventTime;
	private String message;

	public CustomerEnquireList() {
		super();

	}

	public CustomerEnquireList(long id, String name, String email, String mobile, String events, String eventDate,
			String eventTime, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.events = events;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CustomerEnquireList [id=" + id + ",\n name=" + name + ",\n email=" + email + ",\n mobile=" + mobile
				+ ",\n events=" + events + ",\n Event Date=" + eventDate + ",\n Event Time=" + eventTime
				+ ",\n message=" + message + "]";
	}

}
