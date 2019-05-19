package com.jdc.student.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class SecurityController {

	private String loginId;
	private String password;
	
	private HttpServletRequest req;
	
	@PostConstruct
	private void init() {
		req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public String login() {

		try {
			req.login(loginId, password);
			
			boolean result = req.isUserInRole("Admin");
			System.out.println(result);
			
			return "/admin/home";
		} catch (ServletException e) {
			return "/login?error=1";
		}

	}

	public String logout() {
		
		try {
			req.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		return "/index.xhtml";
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
