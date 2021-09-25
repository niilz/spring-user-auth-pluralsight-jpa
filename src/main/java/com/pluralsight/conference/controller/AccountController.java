package com.pluralsight.conference.controller;

import javax.validation.Valid;

import com.pluralsight.conference.model.Account;
import com.pluralsight.conference.service.AccountService;
import com.pluralsight.conference.util.OnCreateAccountEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
  
	@GetMapping("/account")
	public String getRegistration(@ModelAttribute("account") Account account) {
		return "account";
	}

	@PostMapping("/account")
	public String addRegistration(@Valid @ModelAttribute("account") Account
			account, BindingResult result) {

		// check for errors
		// should verify that account and user does not exist
		// should verify that email is correct

		// encrypt password
		account.setPassword(encoder.encode(account.getPassword()));
		
		// create the account
		account = accountService.create(account);

		// fire off event on creation
		var event = new OnCreateAccountEvent(account, "conference_war");
		applicationEventPublisher.publishEvent(event);
		
		return "redirect:account";
	}

	@GetMapping("/accountConfirm")
	public String confirmAccount(@RequestParam("token") String token) {
		System.out.println("The given Token: " + token);
		accountService.confirmAccount(token);
		return "accountConfirmed";
	}
}
