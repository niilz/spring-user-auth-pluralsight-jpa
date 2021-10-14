package com.pluralsight.conference.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reset_tokens")
public class ResetToken {

	public static final int EXPIRATION = 60 * 24;

	@Id
	private String email;
	private String token;
	private LocalDateTime expiryDate;
	private String username;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime calculateExpiryDate(int expiryTimeMinutes) {
		return LocalDateTime.now().plusMinutes(expiryTimeMinutes);
	}

}
