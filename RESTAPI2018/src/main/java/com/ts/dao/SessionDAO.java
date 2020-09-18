package com.ts.dao;

import java.util.List;

import com.rest.dto.Instructor;
import com.rest.dto.SessionDetails;
import com.rest.dto.Subject;
import com.ts.db.HibernateTemplate;

public class SessionDAO {
	
	public int register(SessionDetails sessionDetails) {
		//java.util.Date utilDate = new java.sql.Date(instructor.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(sessionDetails);
	}

	public List<SessionDetails> getSessions() {
		List<SessionDetails> sessionList = 
				HibernateTemplate.getSubjectListByQuery7();
				return sessionList;
	}
	
	
	
	


}
