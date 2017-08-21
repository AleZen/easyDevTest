// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.db.bookstore_example_db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Users implements RowMapper<Users>{

	private String user;
    private String pass;
    private Long id;

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Users obj = new Users();
		try {
			obj.setId(rs.getLong("id"));
			obj.setUser(rs.getString("username"));
			obj.setPass(rs.getString("pass"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	} 
    
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}

