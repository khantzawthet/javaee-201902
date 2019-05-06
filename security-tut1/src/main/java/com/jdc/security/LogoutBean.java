package com.jdc.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LogoutBean {

	public String logout() {
		
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance()
				.getExternalContext().getRequest();
		
		try {
			req.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		return "/index?faces-redirect=true";
	}
}
