package com.pluralsight.conference.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "verification_tokens")
@IdClass(TokenId.class)
public class VerificationToken {

	public static final int EXPIRATION = 60 * 24;

	@Id
	@Column(name = "token")
	private String token;

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "expiry_date")
	private LocalDateTime expiryDate;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDateTime calculateExpiryDate(int expiryTimeMinutes) {
		return LocalDateTime.now().plusMinutes(expiryTimeMinutes);
	}
}
