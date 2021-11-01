package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.UserDetailsEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity, String> {

	@Modifying
	@Query("update UserDetailsEntity u set u.password = ?1 where u.username = ?2")
	public int update(String username, String password);
}
