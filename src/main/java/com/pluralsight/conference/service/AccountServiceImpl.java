package com.pluralsight.conference.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.pluralsight.conference.model.Account;
import com.pluralsight.conference.model.Authority;
import com.pluralsight.conference.model.ConferenceUserDetails;
import com.pluralsight.conference.model.UserDetailsEntity;
import com.pluralsight.conference.model.VerificationToken;
import com.pluralsight.conference.repository.AccountRepository;
import com.pluralsight.conference.repository.UserDetailsRepository;
import com.pluralsight.conference.repository.VerificationTokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public void createVerificationToken(Account account, String token) {
		var verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUsername(account.getUsername());
		var expiryDate = verificationToken.calculateExpiryDate(VerificationToken.EXPIRATION);
		verificationToken.setExpiryDate(expiryDate);

		verificationTokenRepository.save(verificationToken);
	}

	@Override
	public void confirmAccount(String token) {
		// retrieve token
		var verificationToken = verificationTokenRepository.findByToken(token);
		// verify date
		if (verificationToken.getExpiryDate().isAfter(LocalDateTime.now())) {
		// move from account table to user details table
			var account = accountRepository.findByUsername(verificationToken.getUsername());
			// create user details
			var authorities = new ArrayList<Authority>();
			authorities.add(new Authority("ROLE_USER", account.getUsername()));

			var userDetails = new ConferenceUserDetails(account.getUsername(),
					account.getPassword(), authorities);


			var userEntity = new UserDetailsEntity(userDetails);

			userDetailsRepository.save(userEntity);
			// delete from accounts
			accountRepository.delete(account);
			// delete from tokens
			verificationTokenRepository.delete(verificationToken);
		}
	}

	@Override
	public Account create(Account account) {
		return accountRepository.save(account);
	}

}
