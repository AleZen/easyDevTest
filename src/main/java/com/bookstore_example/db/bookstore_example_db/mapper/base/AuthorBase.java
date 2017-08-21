// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.db.bookstore_example_db.mapper.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;
import com.bookstore_example.db.bookstore_example_db.mapper.Author;

public class AuthorBase implements RowMapper<Author>{
	
	private Long _id;
	
	// Attributes
	private String gender;
	private String name;
	private String surname;
	
	
	
	
	
	@Override
	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Author obj = new Author();
		try {
			obj.set_id(rs.getLong("id"));
			
			obj.setGender(rs.getString("gender"));
			obj.setName(rs.getString("name"));
			obj.setSurname(rs.getString("surname"));
			
        	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}

	
    
    
    
    
    
}