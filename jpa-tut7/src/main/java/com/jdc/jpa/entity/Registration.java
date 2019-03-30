package com.jdc.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration implements HotelEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private String customer;
	
	@ManyToOne
	private Room room;
	private SecurityInfo security;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	/* (non-Javadoc)
	 * @see com.jdc.jpa.entity.HotelEntity#getSecurity()
	 */
	@Override
	public SecurityInfo getSecurity() {
		return security;
	}

	/* (non-Javadoc)
	 * @see com.jdc.jpa.entity.HotelEntity#setSecurity(com.jdc.jpa.entity.SecurityInfo)
	 */
	@Override
	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}

}
