package com.jdc.blog.enitty;

import java.util.List;

public interface BlogRepository {

	void insert(Blog blog);

	List<Blog> selectAll();

}