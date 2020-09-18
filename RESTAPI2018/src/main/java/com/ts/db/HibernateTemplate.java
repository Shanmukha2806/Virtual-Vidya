package com.ts.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rest.dto.Course;
import com.rest.dto.Instructor;
import com.rest.dto.Learner;
import com.rest.dto.SessionDetails;
import com.rest.dto.Subject;



public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserPass(String loginId,String password) {
	
	String queryString = "from Learner where mail_id = :loginId and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("loginId", loginId);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  Learner learner = (Learner)queryResult;
	  return learner; 
	}
	public static Object getObjectByUserPassI(String loginId,String password) {
		
		String queryString = "from Instructor where mail_id = :loginId and password =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("loginId", loginId);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Instructor instructor = (Instructor)queryResult;
		  return instructor; 
		}
	public static Object getObjectById(int instructor_id) {
		
		String queryString = "from Instructor where instructor_id = :instructor_id";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setLong("instructor_id", instructor_id);
		  Object queryResult = query.uniqueResult();
		  Instructor instructor = (Instructor)queryResult;
		  return instructor; 
		}
public static Object getObjectById1(int learner_id) {
		
		String queryString = "from Learner where learner_id = :learner_id";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setLong("learner_id", learner_id);
		  Object queryResult = query.uniqueResult();
		  Learner learner= (Learner)queryResult;
		  return learner; 
		}
public static Object getObjectById2(int subject_id) {
	
	String queryString = "from Subject where subject_id = :subject_id";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setLong("subject_id", subject_id);
	  Object queryResult = query.uniqueResult();
	  Subject subject= (Subject)queryResult;
	  return subject; 
	}
	
	public static List<Subject> getSubjectListByQuery()
	{
		return sessionFactory.openSession().createQuery("from Subject").list();
	}
	
	public static List<Course> getSubjectListByQuery1()
	{
		return sessionFactory.openSession().createQuery("from Course").list();
	}
	
	public static List<SessionDetails> getSubjectListByQuery7()
	{
		return sessionFactory.openSession().createQuery("from SessionDetails").list();
	}
	
	
	public static List<Course> getSubjectListByQuery2(int subject_id)
	{
		return sessionFactory.openSession().createQuery("from Course where subject_id =:subject_id").list();
	}
	
	
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class Course, String columName, int value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(Course.class);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
}
