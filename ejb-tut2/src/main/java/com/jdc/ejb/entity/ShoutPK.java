package com.jdc.ejb.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class ShoutPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate shoutDate;
	private int seqNumber;

	public ShoutPK() {
	}

	public ShoutPK(LocalDate shoutDate, int seqNumber) {
		super();
		this.shoutDate = shoutDate;
		this.seqNumber = seqNumber;
	}

	public LocalDate getShoutDate() {
		return shoutDate;
	}

	public void setShoutDate(LocalDate shoutDate) {
		this.shoutDate = shoutDate;
	}

	public int getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(int seqNumber) {
		this.seqNumber = seqNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seqNumber;
		result = prime * result + ((shoutDate == null) ? 0 : shoutDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoutPK other = (ShoutPK) obj;
		if (seqNumber != other.seqNumber)
			return false;
		if (shoutDate == null) {
			if (other.shoutDate != null)
				return false;
		} else if (!shoutDate.equals(other.shoutDate))
			return false;
		return true;
	}

}
