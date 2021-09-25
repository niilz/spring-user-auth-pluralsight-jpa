package com.pluralsight.conference.model;

import java.util.Collection;
import org.springframework.security.core.userdetails.User;

public class ConferenceUserDetails extends User {

	private String nickname;

	public ConferenceUserDetails(String username, String password, Collection<Authority> authorities) {
		super(username, password, authorities);
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}


}
