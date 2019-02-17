package com.jdc.jsf.navigation;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

@Named
@RequestScoped
public class ErrorDemoBean {

	private String message;
	
	@PostConstruct
	public void init() {
		
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		message = ctx.getRequestParameterMap().get("message");
		
		if(null == message) {
			HttpServletResponse resp = (HttpServletResponse) ctx.getResponse(); 
			try {
				resp.sendRedirect("error.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getMessage() {
		return message;
	}
}
