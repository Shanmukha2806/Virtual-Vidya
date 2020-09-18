package com.rest.dto;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement
@Entity
public class Instructor {
	
	
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	private int instructor_id;
	private String organisation_name;
	private String username;
	private String mail_id;
	private String password;
	private String mobile;
	
	
	
	
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Instructor(int instructor_id, String organisation_name, String username, String mail_id, String password,
			String mobile) {
		super();
		this.instructor_id = instructor_id;
		this.organisation_name = organisation_name;
		this.username = username;
		this.mail_id = mail_id;
		this.password = password;
		this.mobile = mobile;
	}




	
	public String getOrganisation_name() {
		return organisation_name;
	}
	public void setOrganisation_name(String organisation_name) {
		this.organisation_name = organisation_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public int getInstructor_id() {
		return instructor_id;
	}




	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}
	
	
	


	


	


	


	


	

	


	
	
	
	
	

}
