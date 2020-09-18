package com.rest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "subject_id")
@Entity

public class Subject {
	
	
	@Id  
    @GeneratedValue 
	private int subject_id;
	
	
	private String subject_name;
	
	
	@OneToMany(mappedBy="subject",fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Course> empList =new ArrayList<Course>();
	
	
	
	
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	
	
	







	public Subject(int subject_id, String subject_name, List<Course> empList, List<Instructor> instructor,
			List<Learner> learner) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.empList = empList;
		this.instructor = instructor;
		this.learner = learner;
	}















	@ManyToMany(targetEntity = Instructor.class)  
	@JoinTable 
	private List<Instructor> instructor = new ArrayList<Instructor>();  
	  




	@ManyToMany(targetEntity = Learner.class)  
	@JoinTable 
	private List<Learner> learner = new ArrayList<Learner>();


	
	public int getSubject_id() {
		return subject_id;
	}





	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}





	public String getSubject_name() {
		return subject_name;
	}





	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}





	public List<Course> getEmpList() {
		return empList;
	}





	public void setEmpList(List<Course> empList) {
		this.empList = empList;
	}





	public List<Instructor> getInstructor() {
		return instructor;
	}





	public void setInstructor(List<Instructor> instructor) {
		this.instructor = instructor;
	}


	public List<Learner> getLearner() {
		return learner;
	}


	public void setLearner(List<Learner> learner) {
		this.learner = learner;
	}
	
	





	





	





	





	

	



	
	
	
	
	
	

}
