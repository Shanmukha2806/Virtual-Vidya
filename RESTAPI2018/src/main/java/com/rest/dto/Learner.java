package com.rest.dto;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@XmlRootElement
@Entity
public class Learner {
	
	@Id@GeneratedValue
	private int learner_id;
	private String learner_name;
	private String mail_id;
	private String password;
	
	
	public Learner() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	
	
	
	public Learner(int learner_id, String learner_name, String mail_id, String password) {
		super();
		this.learner_id = learner_id;
		this.learner_name = learner_name;
		this.mail_id = mail_id;
		this.password = password;
		
	}








	




	public int getLearner_id() {
		return learner_id;
	}





	public void setLearner_id(int learner_id) {
		this.learner_id = learner_id;
	}





	public String getLearner_name() {
		return learner_name;
	}





	public void setLearner_name(String learner_name) {
		this.learner_name = learner_name;
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













	
	




	


	

		
	
	
	
	

}
