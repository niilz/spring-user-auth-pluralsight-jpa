package com.pluralsight.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PasswordController {
	
	@GetMapping("/password")
	public String getPasswordReset(@ModelAttribute("password") Password password)	{
		return "password";
	}
}
