// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.db.bookstore_example_db.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.bookstore_example.db.bookstore_example_db.mapper.Users;

@Service
public class UsersService{

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

    	
	public Users login(String username, String pass) {
	    
		String sql = "select * from Users where \"username\" = :username AND  \"pass\" = :pass";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
		.addValue("username", username)
		.addValue("pass", pass);
	    
	    try {
		    return jdbcTemplate.queryForObject(sql, parameters, new Users());
	    } catch(EmptyResultDataAccessException e){
	    	return null;
	    }
	}
}