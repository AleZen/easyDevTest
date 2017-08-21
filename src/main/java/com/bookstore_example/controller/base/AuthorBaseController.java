// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.controller.base;

import org.springframework.security.access.annotation.Secured;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore_example.db.bookstore_example_db.service.AuthorService;
import com.bookstore_example.db.bookstore_example_db.mapper.Author;

public class AuthorBaseController {

	AuthorService authorService = new AuthorService();



//CRUD METHODS


    //CRUD - CREATE
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/author", method = RequestMethod.POST, headers = "Accept=application/json")
	public Author insert(@RequestBody Author obj) {
		Author result = authorService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		authorService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Author get(@PathVariable Long id) {
		Author obj = authorService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/author", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Author> getList() {
		List<Author> list = authorService.getList();
		return list;
	}
	
	

    //CRUD - EDIT
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/author/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Author update(@RequestBody Author obj, @PathVariable("id") Long id) {
		Author result = authorService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
