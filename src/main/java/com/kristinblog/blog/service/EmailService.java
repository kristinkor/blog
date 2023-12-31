package com.kristinblog.blog.service;

import javax.mail.internet.MimeMessage;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

import com.kristinblog.blog.models.ContactFormDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	Logger logger = LogManager.getLogger(EmailService.class);
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String emailTo;
	
	@Async
	public void send(ContactFormDTO contactFormDTO) {
		
		// prepare email format
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
				mimeMessage.setSubject(contactFormDTO.getSubject());
				
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.setTo("kristinkor@gmail.com");
				helper.setText(
							"<html>"
								+	"<body>" 
									+	"Email sent by: " + contactFormDTO.getName() + "<br/>"
									+   "Email address: " + contactFormDTO.getEmail()+ "<br/>"
									+   "Subject: " + contactFormDTO.getSubject()+ "<br/>"
									+	"Number: " + contactFormDTO.getNumber()+ "<br/>"
									+   "<br/><br/>"
									+   contactFormDTO.getMessage()
								+   "</body>"
							+ "</html>", true);
			}
		};
		
		try {
			emailSender.send(preparator);
			System.out.println("success?");
			logger.info("Email sent with success.");
		} catch (Exception e) {
			logger.error("Error sending email.");
			throw e;
		}		
	}
	
	

}