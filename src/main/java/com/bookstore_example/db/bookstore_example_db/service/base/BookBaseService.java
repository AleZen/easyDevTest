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

import com.bookstore_example.db.bookstore_example_db.mapper.Book;
import com.bookstore_example.db.bookstore_example_db.service.BookService;

@Service
public class BookBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}


    //CRUD METHODS
    
    
    //CRUD - CREATE
    	
	public Book insert(Book obj) {
		
		long id = jdbcTemplate.queryForObject("SELECT nvl(max(\"id\")+1, 1) FROM Book", new MapSqlParameterSource(), Long.class);
		obj.set_id(id);
		
		String sql = "INSERT INTO Book (\"id\", \"title\",\"year\" , \"_author\" )	VALUES (:id, :title,:year , :_author  )";

		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("title", obj.getTitle())
			.addValue("year", obj.getYear())
			.addValue("_author", obj.get_author());

		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
        	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM Book WHERE \"id\"=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
        
    //CRUD - FIND BY _author
    	
	public List<Book> findBy_author(Long id_author) {
		
		String sql = "select * from Book WHERE \"_author\" = :id_author";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
		.addValue("id_author", id_author);
	    
	    return jdbcTemplate.query(sql, parameters, new Book());
	}
	
    	
        	
    //CRUD - GET ONE
    	
	public Book get(Long id) {
	    
		String sql = "select * from Book where \"id\" = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return jdbcTemplate.queryForObject(sql, parameters, new Book());
	}

    	
        	
    //CRUD - GET LIST
    	
	public List<Book> getList() {
	    
		String sql = "select * from Book";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new Book());
	}

    	
        	
        
    //CRUD - EDIT
    	
	public Book update(Book obj, Long id) {

		String sql = "UPDATE Book SET \"title\" = :title,\"year\" = :year , \"_author\" = :_author  WHERE \"id\"=:id";

		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("title", obj.getTitle())
			.addValue("year", obj.getYear())
			.addValue("_author", obj.get_author());

		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    
    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in  Custom.js
     */
    


}
