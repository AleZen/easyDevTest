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

import com.bookstore_example.db.bookstore_example_db.service.BookService;
import com.bookstore_example.db.bookstore_example_db.mapper.Book;

public class BookBaseController {

	BookService bookService = new BookService();



//CRUD METHODS


    //CRUD - CREATE
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/book", method = RequestMethod.POST, headers = "Accept=application/json")
	public Book insert(@RequestBody Book obj) {
		Book result = bookService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		bookService.delete(id);
	}
	

    //CRUD - FIND BY _author
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/book/findBy_author/{key}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Book> findBy_author(@PathVariable("key") Long id_author) {
		List<Book> list = bookService.findBy_author(id_author);
		return list;
	}
	
	
    //CRUD - GET ONE
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book get(@PathVariable Long id) {
		Book obj = bookService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/book", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Book> getList() {
		List<Book> list = bookService.getList();
		return list;
	}
	
	

    //CRUD - LINK LIST _author
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/book/_author/{key}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void linkList_author(@PathVariable("key") Long id_author) {}
	

    //CRUD - EDIT
    @Secured({"ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/book/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Book update(@RequestBody Book obj, @PathVariable("id") Long id) {
		Book result = bookService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
