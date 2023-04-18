package tests;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SimpleMail2 {

	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub
		String to = "email2sachinsrivastava@gmail.com";
	    String subject = "subject";
	    String msg ="email text....";
	    final String from ="kktest100@outlook.com";
	    final  String password ="Kk@%&NBS3344";


	    Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp-mail.outlook.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "587");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "587");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(from,password);  
	   }  
	   });  

	   //session.setDebug(true);  
	   Transport transport = session.getTransport();  
	   InternetAddress addressFrom = new InternetAddress(from);  

	   MimeMessage message = new MimeMessage(session);  
	   message.setSender(addressFrom);  
	   message.setSubject(subject);  
	   message.setContent(msg, "text/plain");  
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	   
	   Multipart multipart = new MimeMultipart();

       MimeBodyPart attachmentPart = new MimeBodyPart();

       MimeBodyPart textPart = new MimeBodyPart();

       try {

           File f =new File("E:\\New Eclipse\\Practise\\reports\\extentreport.html");

           attachmentPart.attachFile(f);
           textPart.setText("This is text");
           multipart.addBodyPart(textPart);
           multipart.addBodyPart(attachmentPart);

       } catch (IOException e) {

           e.printStackTrace();

       }
       message.setContent(multipart);

	   transport.connect();  
	   Transport.send(message);  
	   transport.close();
	   }
}
