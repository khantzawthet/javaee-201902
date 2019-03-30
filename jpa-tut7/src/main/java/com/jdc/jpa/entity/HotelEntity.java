package com.jdc.jpa.entity;

import java.io.Serializable;

public interface HotelEntity extends Serializable{

	SecurityInfo getSecurity();

	void setSecurity(SecurityInfo security);

}