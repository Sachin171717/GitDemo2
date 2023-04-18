package tests;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;
import org.apache.commons.mail.*;

public class SimpleMail {

	@SuppressWarnings("deprecation")
	@Test (timeOut=200000)
	public void email() throws EmailException, InterruptedException
	{
		// TODO Auto-generated method stub

		System.out.println("MailStarted");
		Email email = new SimpleEmail();
		email.setHostName("smtp-mail.outlook.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("kktest100@outlook.com", "Kk@%&NBS3344"));
		email.setSSLOnConnect(true);
		email.setFrom("sachin@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("bhondaneanil@gmail.com");
		//Email email2 = new SimpleEmail();
		//email.setStartTLSRequired(true);
		EmailConstants.SMTP.wait(100000);
		email.send();
		System.out.println("MailSent");
	}

}
