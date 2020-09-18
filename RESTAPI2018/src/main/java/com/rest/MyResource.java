package com.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.PathParam;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.dto.Course;
import com.rest.dto.Email;
import com.rest.dto.Instructor;
import com.rest.dto.Learner;
import com.rest.dto.SessionDetails;
import com.rest.dto.Subject;
import com.ts.dao.CourseDAO;
import com.ts.dao.InstructorDAO;
import com.ts.dao.LearnerDAO;
import com.ts.dao.SessionDAO;
import com.ts.dao.SubjectDAO;
import com.ts.dao.emailSending;

@Path("myresource")
public class MyResource{

    
	@Path("registerInstructor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerInstructor(Instructor instructor){
    	
		System.out.println("hhhhh");
		System.out.println(instructor); 
		
		String pwd = instructor.getPassword();
		instructor.setPassword(securepassword(pwd));
		
    	InstructorDAO instructorDAO = new InstructorDAO();
    	instructorDAO.register(instructor);
    	
    }
	
	@Path("registerLearner")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerInstructor(Learner learner){
    	
		
		System.out.println(learner); 
		
		String pwd = learner.getPassword();
		learner.setPassword(securepassword(pwd));
		
		LearnerDAO learnerDAO = new LearnerDAO();
  	    learnerDAO.register(learner);
    	
    }
	
	public String securepassword(String pwd){
		char[] chars = pwd.toCharArray();
		for (int i=0; i<chars.length; i++){
			chars[i] += 15;}
			String str2 = String.valueOf(chars);
		return str2 ;
	}
	 @Path("registerSubject")
	    @POST
	    @Produces(MediaType.TEXT_PLAIN)
	    public void registerSubject(Subject subject) {
		 
		 System.out.println(subject);
	    	
	    	SubjectDAO subjectDAO = new SubjectDAO();
	    	subjectDAO.register(subject);
	    	
	    	
	    	
	    }
	@Path("getUserPassJ/{mail_id}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Learner getUserPassJ(@PathParam("mail_id") String mail_id,@PathParam("password") String password){
		
		System.out.println("recieved in path params: " + mail_id + " "+ password);
		System.out.println(mail_id);
		System.out.println(password);
		LearnerDAO  learnerDAO = new LearnerDAO();
		
		char[] chars = password.toCharArray();
		System.out.println(password);
		for (int i=0; i<chars.length; i++){
			chars[i] += 15;}
		String str2 = String.valueOf(chars);
		
		Learner learner = learnerDAO.getUserPass(mail_id,str2);
		return learner;
		
    	 }
	
	@Path("getUserPassI/{mail_id}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Instructor getUserPassI(@PathParam("mail_id") String mail_id,@PathParam("password") String password){
		
		System.out.println("recieved in path params: " + mail_id + " "+ password);
		
		InstructorDAO  instructorDAO = new InstructorDAO();
		char[] chars = password.toCharArray();
		System.out.println(password);
		for (int i=0; i<chars.length; i++){
			chars[i] += 15;}
		String str2 = String.valueOf(chars);
	
		
		
		Instructor instructor = instructorDAO.getUserPass(mail_id,str2);
		return instructor;
		
    	 }
	@Path("viewProfile/{instructor_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Instructor viewProfile(@PathParam("instructor_id") int instructor_id){
		InstructorDAO  instructorDAO = new InstructorDAO();
		Instructor instructor = instructorDAO.viewProfile(instructor_id);
		return instructor;
		
		
	}
	
	@Path("viewProfile1/{learner_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Learner viewProfile1(@PathParam("learner_id") int learner_id){
		LearnerDAO  learnerDAO = new LearnerDAO();
		Learner learner = learnerDAO.viewProfile1(learner_id);
		return learner;
		
		
	}
	
	@Path("viewProfile2/{subject_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Subject viewProfile2(@PathParam("subject_id") int subject_id){
		SubjectDAO  subjectDAO = new SubjectDAO();
		Subject subject = subjectDAO.viewProfile2(subject_id);
		return subject;
		
		
	}
	
	@Path("getAllSubjects")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Subject> getAllSubjects(){
		
		SubjectDAO subjectDAO = new SubjectDAO();
		List<Subject> subList = subjectDAO.getSubjects();
		return (ArrayList<Subject>) subList;

	}
	
	@POST
	@Path("/uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream,@FormDataParam("Image") FormDataContentDisposition
			formDataContentDisposition,@FormDataParam("course_name") String course_name,@FormDataParam("course_description") String course_description, @FormDataParam("subject") String subjectd) throws IOException{
		ObjectMapper objMapper = new ObjectMapper();
		Subject subject = objMapper.readValue(subjectd, Subject.class);
		
		int read = 0;
		byte[] bytes = new byte[1024];

		String path = this.getClass().getClassLoader().getResource("").getPath();
		String pathArr[] = path.split("/WEB-INF/classes/");

		FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image",formDataContentDisposition.getFileName()));

		while((read = fileInputStream.read(bytes)) != -1){
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		Course course = new Course();
		course.setCourse_name(course_name);
		course.setCourse_description(course_description);
		
		course.setImage_name(formDataContentDisposition.getFileName());
		course.setSubject(subject);
		CourseDAO courseDAO = new CourseDAO();
		courseDAO.register(course);
		
	}
	
	@Path("getAllProducts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> getProductsAll(){

		CourseDAO   courseDAO = new CourseDAO();
		List<Course> proList = courseDAO.getCourses();
		return (ArrayList<Course>) proList;

	}
	
	@Path("getImageById/{subject_id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> getImageById(@PathParam("subject_id") int subject_id){
		
		CourseDAO   courseDAO = new CourseDAO();
		List<Course> courseList = courseDAO.getImageList(subject_id);
		
		System.out.println(courseList);
		
		return (ArrayList<Course>) courseList;
		
		
	}
	
	@Path("registerSession")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerSession(SessionDetails sessionDetails){
    	
		System.out.println("hhhhh");
		System.out.println(sessionDetails); 
    	SessionDAO sessionDAO = new SessionDAO();
    	sessionDAO.register(sessionDetails);
    	
    }
	@Path("getAllSessions")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<SessionDetails> getAllSessions(){
		
		SessionDAO sessionDAO = new SessionDAO();
		List<SessionDetails> sessionList = sessionDAO.getSessions();
		System.out.println(sessionList);
		return (ArrayList<SessionDetails>) sessionList;

	}
	    @Path("email")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public void getmails(Email emails){
			
		 System.out.println(emails);
	    	emailSending email = new emailSending();
	    	email.sendEmail(emails);
	    	
	    		

		}
	    
	    @Path("updateEmp")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void updateEmp(Instructor instructor){
			System.out.println("Data recieved in update"+ instructor);

			InstructorDAO instructorDAO = new InstructorDAO();
			instructorDAO.updateEmployee(instructor);



		}
	    @Path("updateEmp1")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void updateEmp(Learner learner){
			System.out.println("Data recieved in update"+ learner);

			LearnerDAO learnerDAO = new LearnerDAO();
			learnerDAO.updateEmployee1(learner);



		}
}