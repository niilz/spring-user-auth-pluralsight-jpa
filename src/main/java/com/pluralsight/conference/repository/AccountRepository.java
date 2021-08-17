package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepository extends CrudRepository<Account, String> {

	public Account save(Account account);

}
