package com.ts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.rest.dto.Course;
import com.rest.dto.Instructor;
import com.rest.dto.Subject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ts.db.HibernateTemplate;

public class CourseDAO {
	
private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public int register(Course course) {
		//java.util.Date utilDate = new java.sql.Date(instructor.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(course);
	}

	public List<Course> getCourses() {
		List<Course> courseList = 
				HibernateTemplate.getSubjectListByQuery1();
		return courseList;
	}
	
	public List<Course> getImageList(int subject_id) {
		Session session=sessionFactory.openSession();
		List<Course> list = session.createCriteria(Course.class).createCriteria("subject").add(Restrictions.eq("id",subject_id )).list();
		return list;
	}
	
	

}
