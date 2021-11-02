package com.pluralsight.conference.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users")
public class UserDetailsEntity {

	@Id
	private String username;
	private String password;
	private String nickname;
	private boolean enabled;
	@OneToMany(targetEntity = Authority.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsEntity() {
	}

	public UserDetailsEntity(ConferenceUserDetails user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.enabled = user.isEnabled();
		this.nickname = user.getNickname();
		this.authorities = user.getAuthorities();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<Authority> authorities) {
		this.authorities = authorities;
	}

}
