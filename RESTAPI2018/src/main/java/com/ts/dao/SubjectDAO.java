package com.ts.dao;

import java.util.List;

import com.rest.dto.Learner;
import com.rest.dto.Subject;
import com.ts.db.HibernateTemplate;

public class SubjectDAO {
	
	public int register(Subject subject) {
		//java.util.Date utilDate = new java.sql.Date(instructor.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(subject);
	}

	public List<Subject> getSubjects() {
		List<Subject> subList = 
		HibernateTemplate.getSubjectListByQuery();
		return subList;
	}

	public Subject viewProfile2(int subject_id) {
		// TODO Auto-generated method stub
		return (Subject) HibernateTemplate.getObjectById2(subject_id);
	}


}
