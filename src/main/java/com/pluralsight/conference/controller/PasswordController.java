package com.pluralsight.conference.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import com.pluralsight.conference.model.Password;
import com.pluralsight.conference.repository.PasswordRepository;
import com.pluralsight.conference.repository.UserDetailsRepository;
import com.pluralsight.conference.service.PasswordService;
import com.pluralsight.conference.util.OnPasswordResetEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasswordController {

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	@Autowired
	private PasswordRepository passwordRepository;
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	@Autowired
	private PasswordEncoder encoder;
	
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

	@GetMapping("/passwordReset")
	public ModelAndView getNewPassword(@RequestParam("token") String token) {
		// verify Token
		var password = new Password();
		password.setToken(token);

		return new ModelAndView("resetPassword", "password", password);
	}

	@PostMapping("/passwordReset")
	public String saveNewPassword(@RequestParam("token") String token,
			@ModelAttribute("password") Password password) {

			// Match the password
			// verfy token
			var resetToken = passwordRepository.findByToken(token);
			if (resetToken.getExpiryDate().isAfter(LocalDateTime.now())) {
				password.setPassword(encoder.encode(password.getPassword()));
				userDetailsRepository.update(resetToken.getUsername(), password.getPassword());
				return "redirect:passwordReset?reset=true&token=0";
			}
			return "tokenExpired";

	}
}
