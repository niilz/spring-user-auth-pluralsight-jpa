package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Account;
import com.pluralsight.conference.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void createVerificationToke(Account account, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmAccount(String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account create(Account account) {
		accountRepository.save(account);
		return null;
	}

}
