package com.jdc.shop.beans.dto;

import java.io.Serializable;

public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
