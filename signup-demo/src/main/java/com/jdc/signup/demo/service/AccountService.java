package com.jdc.signup.demo.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.signup.demo.entity.Account;
import com.jdc.signup.demo.entity.Account.Role;

@LocalBean
@Stateless
public class AccountService {
	
	@PersistenceContext
	private EntityManager em;

	public void createUser(String loginId, String password) {

		Account ac = new Account();
		ac.setLoginId(loginId);
		ac.setPassword(Sha256Digest.digest(password));
		ac.setRole(Role.Member);
		
		em.persist(ac);
	}

}
