package com.ts.dao;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.rest.dto.Email;

import java.util.Properties;

public class emailSending {
public void sendEmail(Email learner){

System.out.println("In mail sending");

       final String username = "kodidelamadhumitha@gmail.com";
       final String password = "laxmimitha";
       
       String sendMessage = "Hello\n"
    		   +"I am "
    		   +learner.getName()+"\n"
    		   +"\n"
    		   +"message:\n"
    		   +learner.getMessage()+"\n"
    		   +"\n"
    		   +"reply to:\n"
    		   +learner.getEmail();
       
       
       Properties prop = new Properties();
       prop.put("mail.smtp.host", "smtp.gmail.com");
       prop.put("mail.smtp.port", "587");
       prop.put("mail.smtp.auth", "true");
       prop.put("mail.smtp.starttls.enable", "true"); //TLS

       Session session = Session.getInstance(prop,
               new javax.mail.Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(username, password);
                   }
               });

       try {

           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress( learner.getEmail()));
           message.setRecipients(
                   Message.RecipientType.TO,
                   InternetAddress.parse("kodidelamadhumitha@gmail.com")
           );
           message.setSubject("contact us");
          
           
           message.setText(sendMessage);
          

           Transport.send(message);

           System.out.println("Done");

       } catch (MessagingException e) {
           e.printStackTrace();
       }
   }
}