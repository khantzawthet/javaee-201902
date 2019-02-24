package com.jdc.blog.enitty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcBlogRepository implements BlogRepository {

	/* (non-Javadoc)
	 * @see com.jdc.blog.enitty.BlogRepository#insert(com.jdc.blog.enitty.Blog)
	 */
	@Override
	public void insert(Blog blog) {
		
		String sql = "insert into blog (title, body, user) values (?, ?, ?)";
		
		try(Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/blog_db", "root", "admin");
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, blog.getTitle());
			stmt.setString(2, blog.getBody());
			stmt.setString(3, blog.getUser());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.jdc.blog.enitty.BlogRepository#selectAll()
	 */
	@Override
	public List<Blog> selectAll() {
		
		List<Blog> list = new ArrayList<>();
		String sql = "select * from blog";
		
		try(Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/blog_db", "root", "admin");
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Blog b = new Blog();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setBody(rs.getString("body"));
				b.setUser(rs.getString("user"));
				
				list.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
