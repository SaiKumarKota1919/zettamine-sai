package com.zettamine.login.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.zettamine.login.dto.EmailDto;

import jakarta.activation.URLDataSource;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServices {
	private JavaMailSender mailSender;

	public EmailServices(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}
	
	public boolean sendEmail(EmailDto emailDto) {
		String contents = getEmailContents(emailDto.getFName(), emailDto.getLName(), emailDto.getEmail(),emailDto.getPassword());
		String subject = emailDto.getSubject();
		//String from = "saikumar.k1829@gmail.com";
		String to = emailDto.getEmail();
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setSubject(subject);
			//helper.setFrom("zettamine-admin@zettamine.com");
			helper.setTo(to);
			helper.setText(contents, true);

			URLDataSource source = new URLDataSource(this.getClass().getResource("/images/logo.jpg"));
			helper.addInline("CompanyLogo", source);
			
			mailSender.send(message);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	private String getEmailContents(String fname, String lname, String email, String pass) {
		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("email-templates/new-user-mail.html");
		String str=null;
		try {
			str = IOUtils.toString(fis, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = String.format(str, fname, lname, email, pass);
		
		return data;
	}
}
