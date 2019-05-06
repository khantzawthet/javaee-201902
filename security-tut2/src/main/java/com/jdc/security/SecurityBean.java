package com.jdc.security;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class SecurityBean {

	private String loginId;
	private String password;
	
	private HttpServletRequest req;
	
	@PostConstruct
	private void init() {
		req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
	}

	public String login() {
		
		try {
			req.login(loginId, password);
			
			String referer = req.getHeader("Referer");
			
			String fullPath = referer.split(";")[0];
			
			String contextPath = req.getServletContext().getContextPath();
			
			String [] array = fullPath.split(contextPath);
			
			return array[array.length - 1];
			
		} catch (ServletException e) {
			return "/index?error=1";
		}
	}

	public String logout() {
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
