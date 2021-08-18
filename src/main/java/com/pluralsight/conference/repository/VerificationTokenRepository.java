package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.VerificationToken;

import org.springframework.data.repository.CrudRepository;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, String> {
}
