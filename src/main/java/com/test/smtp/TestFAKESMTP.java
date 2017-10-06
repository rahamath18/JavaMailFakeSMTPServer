package com.test.smtp;

 

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class TestFAKESMTP {
	
	public static void main(String[] args) {
		
		sendEmail();
	}
	
	private static void sendEmail() {
		
		try {
 
			InternetAddress[] distributionList = InternetAddress.parse("rahamath1805@gmail.com,rahamath1805@gmail.com",false);
			String from = "rahamath1805@gmail.com";
			String subject = "Test email from JavaMail using Fake SMTP Server";
 
			Properties props = new Properties();
			props.put("mail.smtp.host", "localhost");
			props.put("mail.smtp.port", "25");
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(false);
			
			Message msg = new MimeMessage(session);
			String message = "<div style=\"color:red;\">Email with static template</br></br><table border=\"1\" style=\"width:20%\"><tr><td>Email</td><td>Test</td><td>50</td></tr><tr><td>Email</td><td>Test</td><td>50</td></tr><tr><td>Email</td><td>Test</td><td>50</td></tr></table></div>";
			msg.setContent(message, "text/html; charset=utf-8");
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, distributionList);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			Transport.send(msg);
 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
 
}
