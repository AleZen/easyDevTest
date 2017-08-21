// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.db.bookstore_example_db.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.bookstore_example.db.bookstore_example_db.mapper.Roles;

@Service
public class RolesService{

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}


	public ArrayList<Roles> getRoles(Long id_user) {
		
		String sql = "select * from Roles WHERE \"_user\" = :id_user";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
		.addValue("id_user", id_user);
	    
	    return (ArrayList<Roles>) jdbcTemplate.query(sql, parameters, new Roles());
	}
}