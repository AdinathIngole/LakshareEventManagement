package com.LakshareEventManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmailGenerate")
public class EmailSender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String reciption;
	private String message;
	private String subject;
	
	public EmailSender() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailSender(Integer id, String reciption, String message, String subject) {
		super();
		this.id = id;
		this.reciption = reciption;
		this.message = message;
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReciption() {
		return reciption;
	}

	public String setReciption(String reciption) {
		return this.reciption = reciption;
	}

	public String getMessage() {
		return message;
	}

	public String setMessage(String message) {
		return this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public String setSubject(String subject) {
		return this.subject = subject;
	}

	@Override
	public String toString() {
		return "EmailSender [id=" + id + ", reciption=" + reciption + ", message=" + message + ", subject=" + subject
				+ "]";
	}
	

	
}

	


