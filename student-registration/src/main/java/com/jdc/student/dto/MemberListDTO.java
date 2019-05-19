package com.jdc.student.dto;

import java.io.Serializable;

import com.jdc.student.entity.Roles.Role;

public class MemberListDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String loginId;
	private String password;
	private String name;

	public MemberListDTO(String loginId, String name) {
		super();
		this.loginId = loginId;
		this.name = name;
	}

	private Role role;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
