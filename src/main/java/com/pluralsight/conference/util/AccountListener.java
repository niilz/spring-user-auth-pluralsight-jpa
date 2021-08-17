package com.pluralsight.conference.util;

import java.util.UUID;

import com.pluralsight.conference.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class AccountListener implements ApplicationListener<OnCreateAccountEvent> {

	private String serverUrl = "https://localhost:8080/";

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private AccountService accountService;

	@Override
	public void onApplicationEvent(OnCreateAccountEvent event) {
		this.confirmCreateAccount(event);
	}

	private void confirmCreateAccount(OnCreateAccountEvent event) {
		// get the account
		// create a verification token
		var account = event.getAccount();
		String token = UUID.randomUUID().toString();
		accountService.createVerificationToken(account, token);
		
		// get email properties

		// send email
	}

}
