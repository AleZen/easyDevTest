// -------------
// For more documentation visit http://easydev.org/#/documentation/template/java
// -------------

package com.bookstore_example.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthenticationFilter extends OncePerRequestFilter {
	
    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String username = request.getHeader("user");
        String pass = request.getHeader("pass");
        

        AuthenticationService auth = new AuthenticationService(username, pass);
        
        if(auth.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        
        filterChain.doFilter(request, response);
    }

}