package com.jdc.jsf.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jsf.domain.User;

@Named
@ConversationScoped
public class UserRegistration implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	
	@Inject
	private Conversation conversation;
	
	@PostConstruct
	private void init() {
		user = new User();
		if(conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public String confirm() {
		
		if(!conversation.isTransient()) {
			conversation.end();
		}
		
		return "/index";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
