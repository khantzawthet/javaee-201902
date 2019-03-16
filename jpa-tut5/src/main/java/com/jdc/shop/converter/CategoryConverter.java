package com.jdc.shop.converter;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.jdc.shop.entity.Category;
import com.jdc.shop.service.CategoryService;

@Model
public class CategoryConverter implements Converter<Category>{

	@Inject
	private CategoryService service;
	
	@Override
	public Category getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(null != value && !value.isEmpty()) {
			int id = Integer.parseInt(value);
			return service.findById(id);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Category value) {
		
		if(null != value) {
			return String.valueOf(value.getId());
		}
		
		return null;
	}

}
