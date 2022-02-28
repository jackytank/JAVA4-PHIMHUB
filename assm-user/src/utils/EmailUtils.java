package utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

//import model.Email;

public class EmailUtils {
	public static void send(Email email) throws Exception {
//		Properties prop = new Properties();
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//		prop.put("mail.smpt.port", "587");
//		prop.put("mail.smtp.auth", "true");
//		prop.put("mail.smtp.starttls.enable", "true");
//
//		Session session = Session.getInstance(prop, new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
//			}
//		});
//		session.setDebug(true);
//		try {
//			Message message = new MimeMessage(session);
//
//			message.setFrom(new InternetAddress(email.getFrom()));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
//			message.setSubject(email.getSubject());
//			message.setText(email.getContent());
//			Transport.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static void sendWithSendGridAPI(String fromAddress,String toAddress, String subject, String contents, String api_key) throws IOException {
		
		Email from = new Email(fromAddress);
	    Email to = new Email(toAddress);
	    Content content = new Content("text/plain", contents);
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(api_key);
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	}
}
