package com.pluralsight.conference.service;

public interface AccountService {

	Account create(Account, account);

	void createVerificationToke(Account account, String token);

	void confirmAccount(String token);
}
