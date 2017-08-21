// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.db.bookstore_example_db.mapper.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;
import com.bookstore_example.db.bookstore_example_db.mapper.Book;

public class BookBase implements RowMapper<Book>{
	
	private Long _id;
	
	// Attributes
	private String title;
	private Number year;
	
	
	// Relations _author
	private String _author;
	
	
	
	
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book obj = new Book();
		try {
			obj.set_id(rs.getLong("id"));
			
			obj.setTitle(rs.getString("title"));
			obj.setYear(rs.getBigDecimal("year"));
			
        	
        	// Relations 1:m _author
			obj.set_author(rs.getString("_author"));
        	
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	public Number getYear() {
		return year;
	}


	public void setYear(Number year) {
		this.year = year;
	}

	
    
    // Relations 1:m _author
	public String get_author() {
		return _author;
	}

	public void set_author(String _author) {
		this._author = _author;
	}
    
    
    
    
    
}