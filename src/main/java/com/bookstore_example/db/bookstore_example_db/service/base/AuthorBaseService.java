// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.db.bookstore_example_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.bookstore_example.db.bookstore_example_db.mapper.Author;
import com.bookstore_example.db.bookstore_example_db.service.AuthorService;

@Service
public class AuthorBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}


    //CRUD METHODS
    
    
    //CRUD - CREATE
    	
	public Author insert(Author obj) {
		
		long id = jdbcTemplate.queryForObject("SELECT nvl(max(\"id\")+1, 1) FROM Author", new MapSqlParameterSource(), Long.class);
		obj.set_id(id);
		
		String sql = "INSERT INTO Author (\"id\", \"gender\",\"name\",\"surname\"  )	VALUES (:id, :gender,:name,:surname  )";

		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("gender", obj.getGender())
			.addValue("name", obj.getName())
			.addValue("surname", obj.getSurname());

		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
        	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM Author WHERE \"id\"=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
        	
    //CRUD - GET ONE
    	
	public Author get(Long id) {
	    
		String sql = "select * from Author where \"id\" = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return jdbcTemplate.queryForObject(sql, parameters, new Author());
	}

    	
        	
    //CRUD - GET LIST
    	
	public List<Author> getList() {
	    
		String sql = "select * from Author";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new Author());
	}

    	
        
    //CRUD - EDIT
    	
	public Author update(Author obj, Long id) {

		String sql = "UPDATE Author SET \"gender\" = :gender,\"name\" = :name,\"surname\" = :surname  WHERE \"id\"=:id";

		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("gender", obj.getGender())
			.addValue("name", obj.getName())
			.addValue("surname", obj.getSurname());

		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    
    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in  Custom.js
     */
    


}
