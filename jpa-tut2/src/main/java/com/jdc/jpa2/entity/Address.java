package com.jdc.jpa2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

@Entity
@SecondaryTables({
	@SecondaryTable(name = "township"),
	@SecondaryTable(name = "state")
})
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String street;
	@Column(table = "township")
	private String township;
	@Column(table = "state")
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
