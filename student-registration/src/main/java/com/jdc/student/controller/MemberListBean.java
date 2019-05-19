package com.jdc.student.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.student.dto.MemberListDTO;
import com.jdc.student.entity.Roles.Role;
import com.jdc.student.service.MemberService;

@Named
@RequestScoped
public class MemberListBean {

	private Role role;
	private String name;
	private boolean enable;

	private List<MemberListDTO> list;

	@Inject
	private MemberService service;

	@PostConstruct
	private void init() {
		enable = true;
		list = new ArrayList<>();
	}
	
	public List<Role> getRoles() {
		return Arrays.asList(Role.Teacher, Role.Office);
	}

	public String search() {
		list = service.search(role, name, enable);
		return null;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<MemberListDTO> getList() {
		return list;
	}

	public void setList(List<MemberListDTO> list) {
		this.list = list;
	}

}
