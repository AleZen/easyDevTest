// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.bookstore_example.db.bookstore_example_db.mapper.Roles;
import com.bookstore_example.db.bookstore_example_db.mapper.Users;
import com.bookstore_example.db.bookstore_example_db.service.RolesService;
import com.bookstore_example.db.bookstore_example_db.service.UsersService;

public class AuthenticationService implements Authentication {

	private static final long serialVersionUID = 1L;
	private Users user;
	private final UsersService usersService = new UsersService();
	private final RolesService roleService = new RolesService();
	private ArrayList<GrantedAuthority> listRoles;

	public AuthenticationService(String username, String pass) {
		
		// Get user from database
	    user = usersService.login(username, pass); 
	    if (user!= null){
	    	// Add default role
			listRoles = new ArrayList<GrantedAuthority>();
			GrantedAuthority roleDefault = new SimpleGrantedAuthority("ROLE_PRIVATE_USER");
			listRoles.add(roleDefault);
			
			// Get roles from database
			ArrayList<Roles> listDbRoles = roleService.getRoles(user.getId());
			
			for (Roles roles : listDbRoles) {
				GrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + roles.getRole());
				listRoles.add(role);
			}
	    }
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return listRoles;
	}

	@Override
	public boolean isAuthenticated() {
		return user != null;
	}
	
	public Users getUser() {
		return user;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}


}
