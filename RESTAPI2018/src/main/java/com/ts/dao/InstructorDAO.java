package com.ts.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rest.dto.Instructor;
import com.ts.db.HibernateTemplate;

public class InstructorDAO {
	
	
	public int register(Instructor instructor) {
		//java.util.Date utilDate = new java.sql.Date(instructor.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(instructor);
	}

	public Instructor getUserPass(String mail_id, String password) {
		return (Instructor) HibernateTemplate.getObjectByUserPassI(mail_id,password);
	}

	public Instructor viewProfile(int instructor_id) {
		// TODO Auto-generated method stub
		return (Instructor) HibernateTemplate.getObjectById(instructor_id);
	}
	
	public void updateEmployee(Instructor instructor) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.saveOrUpdate(instructor);
        Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		
	}

	
	
	
}
