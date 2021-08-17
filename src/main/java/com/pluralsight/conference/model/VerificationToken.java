package com.pluralsight.conference.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class VerificationToken {

	public static final int EXPIRATION = 60 * 24;

	private String token;

	private String username;

	private LocalDate expiryDate;

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

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDateTime calculateExpiryDate(int expiryTimeMinutes) {
		return LocalDateTime.now().plusMinutes(expiryTimeMinutes);
	}
}
