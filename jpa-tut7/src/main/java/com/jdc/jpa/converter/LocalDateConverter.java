package com.jdc.jpa.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("LocalDateConverter")
public class LocalDateConverter implements Converter<LocalDate>{
	
	private DateTimeFormatter df  = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(null != value && !value.isEmpty()) {
			return LocalDate.parse(value, df);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, LocalDate value) {
		
		if(null != value) {
			return value.format(df);
		}
		
		return null;
	}

}
