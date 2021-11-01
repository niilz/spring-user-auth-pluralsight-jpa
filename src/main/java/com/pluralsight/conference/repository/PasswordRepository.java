package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.ResetToken;

import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<ResetToken, String> {

	ResetToken findByToken(ResetToken resetToken);
	ResetToken findByToken(String token);

	// This can not work here.. Maybe this is a ResetToken instead?!
	//void update(Password password);

}
