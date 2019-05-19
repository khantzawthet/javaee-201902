package com.jdc.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.student.dto.MemberListDTO;
import com.jdc.student.entity.Roles.Role;

@Stateless
@RolesAllowed({"Admin"})
public class MemberService {
	
	@PersistenceContext
	private EntityManager em;

	public List<MemberListDTO> search(Role role, String name, boolean enable) {
		
		if(role.equals(Role.Teacher)) {
			return search("Teacher", name, enable);
		} 

		return search("OfficStaff", name, enable);
	}
	
	private List<MemberListDTO> search(String table, String name, boolean enable) {
		
		StringBuffer sb = new StringBuffer(String.format("select new com.jdc.student.dto.MemberListDTO(m.loginId, m.name) from %s m where m.enable = :enable", table));
		Map<String, Object> params = new HashMap<>();
		
		if(null != name && !name.isEmpty()) {
			sb.append(" and m.name like :name");
			params.put("name", name.concat("%"));
		}
		
		TypedQuery<MemberListDTO> q = em.createQuery(name, MemberListDTO.class);
		for(String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}
		
		return q.getResultList();
	}

}
