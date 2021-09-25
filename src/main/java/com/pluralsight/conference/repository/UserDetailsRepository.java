package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.UserDetailsEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity, String> {
}
