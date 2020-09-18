package com.rest;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.Course;
import com.rest.dto.Instructor;
import com.rest.dto.Learner;
import com.rest.dto.SessionDetails;
import com.rest.dto.Subject;
import com.ts.dao.CourseDAO;
import com.ts.dao.InstructorDAO;
import com.ts.dao.LearnerDAO;
import com.ts.dao.SessionDAO;
import com.ts.dao.SubjectDAO;



@Path("myresource1")
public class MyResource1{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    
    @Path("reg")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String daoTest() {
    	
    	Subject subject = new Subject();
    	
    	subject.setSubject_name("PTSP");
    	
    	SubjectDAO subjectDAO = new SubjectDAO();
    	subjectDAO.register(subject);
    	
    	Course course = new Course();
    	course.setImage_name("mad");
    	course.setCourse_name("strings");
    	course.setCourse_description("in built functions in strings");
    	course.setCourse_offeredby("madhu");
    	course.setSubject(subject);
    	
    	CourseDAO courseDAO = new CourseDAO();
    	courseDAO.register(course);
    	
    	
    	
    	return "Success";
    }
    
    @Path("reg1")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String daoTests() {
    	
    	
    	
    	
    	
    	
    	
    	
    	Instructor instructor1 = new Instructor();
    	
    	instructor1.setOrganisation_name("BVRITN");
    	instructor1.setUsername("priya");
    	instructor1.setMail_id("priya@123");
    	instructor1.setPassword("123");
    	instructor1.setMobile("900000000");
    	
    	InstructorDAO instructorDAO = new InstructorDAO();
    	instructorDAO.register(instructor1);
    	
        Instructor instructor2 = new Instructor();
    	
    	instructor2.setOrganisation_name("BVRITW");
    	instructor2.setUsername("heena");
    	instructor2.setMail_id("heena@1234");
    	instructor2.setPassword("1234");
    	instructor2.setMobile("999009099");
    	
    	InstructorDAO instructorDAO2 = new InstructorDAO();
    	instructorDAO2.register(instructor2);
    	
    	

    	Subject subject = new Subject();
    	
    	subject.setSubject_name("ECAd");
    	
    	ArrayList<Instructor> l1 =new ArrayList<Instructor>();
    	
    	  l1.add(instructor1);  
    	  l1.add(instructor2);  
    	  subject.setInstructor(l1);
    	
    	
    	
 
    	
    	SubjectDAO subjectDAO = new SubjectDAO();
    	subjectDAO.register(subject);
    	
    	

    	return "Success";
    }
    
    
    @Path("reg2")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String daoTestsss(Instructor subject1) {
    	
    	
        Learner learner1 = new Learner();
    	
    	learner1.setLearner_id(1);
    	learner1.setLearner_name("rakesh");
    	learner1.setMail_id("rakesh@123");
    	learner1.setPassword("123");
    	
    	LearnerDAO learnerDAO = new LearnerDAO();
    	  learnerDAO.register(learner1);
    	
        Learner learner2 = new Learner();
    	
    	learner2.setLearner_id(3);
    	learner2.setLearner_name("amith");
    	learner2.setMail_id("amith@123");
    	learner2.setPassword("123");
    	
    	
  	  
  	LearnerDAO learnerDAO2 = new LearnerDAO();
	  learnerDAO2.register(learner2);
    	
    	Subject subject11 = new Subject();
    	
    	subject11.setSubject_id(4);
    	subject11.setSubject_name("maths");
    	
    	
    	
    
    	ArrayList<Learner> l1 =new ArrayList<Learner>();
    	
    	  l1.add(learner1);  
    	  l1.add(learner2);  
    	  subject11.setLearner(l1);
    	
    	  SubjectDAO subjectDAO = new SubjectDAO();
      	  subjectDAO.register(subject11);
      	
    	
    	

    	return "Success";
    }
    
    @Path("registerSession")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
	public String registerInstructor(){
    	SessionDetails sessionDetails = new SessionDetails(1, "maths a","algebra",new Date("1/21/14"),Time.valueOf("10:59:59"));
		
    	
    	SessionDAO sessionDAO = new SessionDAO();
    	sessionDAO.register(sessionDetails);
    	
    	return("success");
    	
    }
    
    @Path("getAllSessions")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public ArrayList<SessionDetails> getAllSessions(){
		
		SessionDAO sessionDAO = new SessionDAO();
		List<SessionDetails> sessionList = sessionDAO.getSessions();
		System.out.println(sessionList);
		return (ArrayList<SessionDetails>) sessionList;

	}
    
    
}
