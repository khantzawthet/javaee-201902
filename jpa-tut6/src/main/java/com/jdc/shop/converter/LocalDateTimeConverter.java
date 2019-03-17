package com.jdc.shop.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Model
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

	private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	@Override
	public LocalDateTime getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value && !value.isEmpty()) {
			return LocalDateTime.parse(value, df);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, LocalDateTime value) {
		
		if(null != value) {
			return value.format(df);
		}
		return null;
	}

	
}
