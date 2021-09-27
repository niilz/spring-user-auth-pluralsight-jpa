package com.pluralsight.conference.controller;

import javax.validation.Valid;

import com.pluralsight.conference.model.Password;
import com.pluralsight.conference.util.OnPasswordResetEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PasswordController {

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@GetMapping("/password")
	public String getPasswordReset(@ModelAttribute("password") Password password)	{
		return "password";
	}

	@PostMapping("/password")
	public String sendEmailToReset(@Valid @ModelAttribute("password") Password
			password, BindingResult result) {
		// check for errors
		// should verify that email is valid
		// verify email from database
		// fire off an event to reset email
		eventPublisher.publishEvent(new OnPasswordResetEvent(password, "conference_war"));
		return "redirect:password?sent=true";
	}
}
