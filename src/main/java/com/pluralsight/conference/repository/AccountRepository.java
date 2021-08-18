package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
