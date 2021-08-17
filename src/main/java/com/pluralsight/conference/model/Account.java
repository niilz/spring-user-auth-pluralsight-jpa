package com.pluralsight.conference.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "accounts")
public class Account {

	@NotNull
	@NotEmpty
	@Id
	@Column(name = "username")
	private String username;

	@NotNull
	@NotEmpty
	@Column(name = "firstname")
	private String firstName;

	@NotNull
	@NotEmpty
	@Column(name = "lastname")
	private String lastName;

	@NotNull
	@NotEmpty
	@Column(name = "password")
	private String password;

	@Transient
	private String matchingPassword;

	@NotNull
	@NotEmpty
	@Column(name = "email")
	private String email;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
