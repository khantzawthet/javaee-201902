package com.jdc.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class SecurityListener {
	
	@PrePersist
	public void prePersist(HotelEntity entity) {
		
		SecurityInfo security = new SecurityInfo();
		security.setCreation(LocalDateTime.now());
		security.setModification(LocalDateTime.now());
		entity.setSecurity(security);
	}

	@PreUpdate
	public void preUpdate(HotelEntity entity) {
		entity.getSecurity().setModification(LocalDateTime.now());
	}
}
