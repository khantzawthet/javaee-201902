package com.jdc.jpa.converter;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.jdc.jpa.entity.Room;
import com.jdc.jpa.service.RoomService;

@Model
public class RoomConverter implements Converter<Room>{
	
	@Inject
	private RoomService service;

	@Override
	public Room getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(null != value  && !value.isEmpty()) {
			return service.findById(Integer.parseInt(value));
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Room value) {
		
		if(null != value) {
			return String.valueOf(value.getId());
		}
		return null;
	}

}
