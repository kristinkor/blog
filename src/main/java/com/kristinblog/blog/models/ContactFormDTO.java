package com.kristinblog.blog.models;

public class ContactFormDTO {

	private String name;
	private String email;
	private String number;
	private String subject;
	private String message;
	
	public ContactFormDTO() {
		super();
	}

	public ContactFormDTO(String name, String email, String number, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.subject = subject;
		this.message = message;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}