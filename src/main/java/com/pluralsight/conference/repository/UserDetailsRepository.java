package com.pluralsight.conference.repository;

import javax.transaction.Transactional;

import com.pluralsight.conference.model.UserDetailsEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity, String> {

	@Modifying
	@Transactional
	@Query("update UserDetailsEntity u set u.password = ?2 where u.username = ?1")
	public int update(String username, String password);
}
