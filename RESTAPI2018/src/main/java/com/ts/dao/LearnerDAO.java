package com.ts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rest.dto.Course;
import com.rest.dto.Instructor;
import com.rest.dto.Learner;
import com.ts.db.HibernateTemplate;

public class LearnerDAO {
	
	public int register(Learner learner) {
		//java.util.Date utilDate = new java.sql.Date(instructor.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(learner);
	}

	public Learner getUserPass(String mail_id, String password) {
		return (Learner) HibernateTemplate.getObjectByUserPass(mail_id,password);
	}

	public Learner viewProfile1(int learner_id) {
		// TODO Auto-generated method stub
		return (Learner) HibernateTemplate.getObjectById1(learner_id);
	}
	public void updateEmployee1(Learner learner) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.saveOrUpdate(learner);
        Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		
	}
	

}
