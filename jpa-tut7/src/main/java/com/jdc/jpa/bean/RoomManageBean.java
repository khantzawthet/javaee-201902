package com.jdc.jpa.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jpa.entity.Room;
import com.jdc.jpa.service.RoomService;

@Named
@ViewScoped
public class RoomManageBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Room room;
	
	@Inject
	private RoomService service;
	
	@PostConstruct
	private void init() {
		String id = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap().get("id");
				
		if(null != id) {
			room = service.findById(Integer.parseInt(id));
		} else  {
			room = new Room();
		}
	}
	
	public String save() {
		service.save(room);
		return "/index?faces-redirect=true";
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public String getTitle() {
		return room.getId() == 0 ? "Add Room" : "Edit Room";
	}
	
}
