// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.db.library_db.mapper.Users;
import com.library.db.library_db.service.UsersService;


@RestController
public class SecurityController {

	private final UsersService usersService = new UsersService();
	
    //LOGIN
	@RequestMapping(value = "/Login", method = RequestMethod.GET, headers = "Accept=application/json")
	public Users login(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getHeader("user");
        String pass = request.getHeader("pass");
        Users user = usersService.login(username, pass); 
		return user;
	}
}
