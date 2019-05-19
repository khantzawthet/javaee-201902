package com.jdc.student.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.student.entity.Account;
import com.jdc.student.entity.Roles;

@LocalBean
@Stateless
public class AccountService {

	@PersistenceContext
	private EntityManager em;
	
	public Account findAccount(String loginId) {
		
		TypedQuery<Account> query = em.createNamedQuery("Account.findAccount", Account.class);
		query.setParameter("loginId", loginId);
		
		List<Account> list = query.getResultList();
		
		for(Account a : list) {
			return a;
		}
		
		return null;
	}

	public List<Roles> findRoles(String loginId) {
		TypedQuery<Roles> query = em.createNamedQuery("Roles.findRoles", Roles.class);
		query.setParameter("loginId", loginId);
		return query.getResultList();
	}

}
