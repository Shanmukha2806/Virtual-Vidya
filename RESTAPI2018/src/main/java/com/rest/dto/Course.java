package com.rest.dto;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@XmlRootElement
@Entity
public class Course {
	
	@Id@GeneratedValue 
	private int course_id;
	private String image_name;
	private String course_name;
	private String course_description;
	private String course_offeredby;
	
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	public Course() {
		super();
		
	}

	

	public Course(int course_id, String image_name,String course_name,  String course_description,String course_offeredby,
			Subject subject) {
		super();
		this.course_id = course_id;
		this.image_name = image_name;
		this.course_name = course_name;
		this.course_offeredby = course_offeredby;
		this.course_description = course_description;
		this.subject = subject;
	}
	
	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}



	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_offeredby() {
		return course_offeredby;
	}

	public void setCourse_offeredby(String course_offeredby) {
		this.course_offeredby = course_offeredby;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}



	public Subject getSubject() {
		return subject;
	}



	public void setSubject(Subject subject) {
		this.subject = subject;
	}



	



	



	
	
	

	

	
	
	
	
	
	
	

}
