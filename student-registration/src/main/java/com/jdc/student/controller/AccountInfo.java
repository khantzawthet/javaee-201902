package com.jdc.student.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.student.entity.Account;
import com.jdc.student.entity.Roles;
import com.jdc.student.service.AccountService;

@Named
@SessionScoped
public class AccountInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Account account;
	private List<Roles> roles;

	@Inject
	private AccountService service;

	@PostConstruct
	private void init() {

		String loginId = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

		account = service.findAccount(loginId);
		roles = service.findRoles(loginId);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

}
