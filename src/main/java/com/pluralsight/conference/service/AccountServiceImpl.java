package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Account;
import com.pluralsight.conference.model.VerificationToken;
import com.pluralsight.conference.repository.AccountRepository;
import com.pluralsight.conference.repository.VerificationTokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account create(Account account) {
		return accountRepository.save(account);
	}

}
