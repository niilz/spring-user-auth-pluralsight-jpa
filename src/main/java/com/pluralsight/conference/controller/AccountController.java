package com.pluralsight.conference.controller;

import javax.validation.Valid;

import com.pluralsight.conference.model.Account;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

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
		
		// create the account

		// fire off event on creation
		
		return "redirect:account";
	}
}
