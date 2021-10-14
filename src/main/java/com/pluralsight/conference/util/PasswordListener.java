package com.pluralsight.conference.util;

import java.util.UUID;

import com.pluralsight.conference.service.PasswordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class PasswordListener implements ApplicationListener<OnPasswordResetEvent> {

	private String serverUrl = "http://localhost:8080/";

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private PasswordService passwordService;

	@Override
	public void onApplicationEvent(OnPasswordResetEvent event) {
		this.resetPassword(event);
	}

	private void resetPassword(OnPasswordResetEvent event) {
		// Create Password-Token
		var password = event.getPassword();
		var token = UUID.randomUUID().toString();
		passwordService.createResetToken(password, token);
		// Get Email Properties
		var recipientAddress = password.getEmail();
		var subject = "Reset Password";
		var confirmationUrl = event.getAppUrl() +	"/passwordReset?token=" + token;
		var message = "Reset password:";
		// send Email
		var email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + "\r\n" + serverUrl + confirmationUrl);
		mailSender.send(email);

	}

}
