package com.jdc.jpa.interceptor;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@ErrorHandler
@Interceptor
public class ExceptionHandlerInterceptor implements Serializable{

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object handle(InvocationContext ctx) {
		
		Object obj = null;
		
		try {
			obj = ctx.proceed();
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(null, e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return obj;
	}
}
