package com.jdc.blog.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.blog.entity.Blog;
import com.jdc.blog.repo.BlogRepository;

@Named
@RequestScoped
public class BlogAddBean {

	private Blog blog;

	@Inject
	private BlogRepository repo;

	@PostConstruct
	private void init() {
		blog = new Blog();
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String str = context.getRequestParameterMap().get("id");
		
		if(null != str) {
			blog = repo.findById(Integer.parseInt(str));
		}
	}

	public String save() {
		repo.add(blog);
		return "/index?faces-redirect=true";
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
