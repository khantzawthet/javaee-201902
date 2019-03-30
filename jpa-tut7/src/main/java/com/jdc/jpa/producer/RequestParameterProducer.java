package com.jdc.jpa.producer;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@RequestScoped
public class RequestParameterProducer {

	@Produces
	@ParameterMap
	public Map<String, String> getParameters() {
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		return ctx.getRequestParameterMap();
	}
}
