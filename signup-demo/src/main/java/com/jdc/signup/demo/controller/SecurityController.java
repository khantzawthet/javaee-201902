package com.jdc.signup.demo.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.jdc.signup.demo.service.AccountService;

@Named
@RequestScoped
public class SecurityController {

	private String loginId;
	private String password;
	
	@Inject
	private AccountService service;
	
	private HttpServletRequest req;
	
	@PostConstruct
	private void init() {
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		req  = (HttpServletRequest) ctx.getRequest();
	}

	public String login() {
		
		try {
			internalLogin();
		} catch (Exception e) {
			return "/login";
		}

		return "/member/home";
	}

	public String signUp() {
		
		
		try {
			// create user
			service.createUser(loginId, password);
			
			// internal login
			internalLogin();
		} catch (ServletException e) {
			return "/signup";
		}

		return "/member/home";
	}
	
	private void internalLogin() throws ServletException {
		req.login(loginId, password);
	}

	public String logout()  {
		req.getSession().invalidate();
		return "/index?faces-redirect=true";
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
