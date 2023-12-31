package com.kristinblog.blog.controller;

import com.kristinblog.blog.models.ContactFormDTO;
import com.kristinblog.blog.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody ContactFormDTO contactFormDTO) {
		
		emailService.send(contactFormDTO);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}