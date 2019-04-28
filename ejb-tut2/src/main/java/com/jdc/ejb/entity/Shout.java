package com.jdc.ejb.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name  = "Shout.findAll", query = "select s from Shout s order by s.id.shoutDate desc, s.id.seqNumber desc")
public class Shout implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShoutPK id;
	private String message;

	public ShoutPK getId() {
		return id;
	}

	public void setId(ShoutPK id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
