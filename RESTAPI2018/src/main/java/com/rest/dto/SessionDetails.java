package com.rest.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@XmlRootElement

@Entity
public class SessionDetails {
	
	@Id@GeneratedValue
	private int id;
	private String subjectName;
	private String CourseName;
	private Date date;
	@JsonFormat(pattern = "HH:mm")
	@JsonDeserialize(using = SqlTimeDeserializer.class)
	private Time time;
	
	public SessionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionDetails(int id, String subjectName, String courseName, Date date, Time time) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.CourseName = courseName;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "SessionDetails [id=" + id + ", subjectName=" + subjectName + ", CourseName=" + CourseName + ", date="
				+ date + ", time=" + time + "]";
	}
	
	
	
	
	
	

}
