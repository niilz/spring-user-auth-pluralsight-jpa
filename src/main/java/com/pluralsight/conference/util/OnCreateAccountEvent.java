package com.pluralsight.conference.util;

import com.pluralsight.conference.model.Account;

import org.springframework.context.ApplicationEvent;

public class OnCreateAccountEvent extends ApplicationEvent {

	private Account account;
	private String appUrl;

	public OnCreateAccountEvent(Account account, String appUrl) {
		super(account);

		this.account = account;
		this.appUrl = appUrl;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

}
