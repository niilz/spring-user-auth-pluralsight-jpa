package com.pluralsight.conference.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorityid")
	private long authorityId;

	@Column(name = "authority")
	private String authority;

	@Column(name = "username")
	private String username;

	public Authority() {
	}

	public Authority(String role, String username) {
		this.authority = role;
		this.username = username;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getAuthority() {
		return authority;
	}

	public void setAuthoriry(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [authority=" + authority + ", authorityId=" + authorityId + ", username=" + username + "]";
	}


}

