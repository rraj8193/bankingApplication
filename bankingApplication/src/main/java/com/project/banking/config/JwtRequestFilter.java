package com.project.banking.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationToken = request.getHeader("Authorization");
		System.out.println("In Request Filter "+ authorizationToken );
		
		String username = "";
		String token = "";
		if(authorizationToken != null && authorizationToken.startsWith("Bearer ")) {
			
			token = authorizationToken.split(" ")[1].trim();
			username = jwtUtils.getUsername(token);
			
			if(username != "") {
				UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
				
				if (userDetails != null) {
		            UsernamePasswordAuthenticationToken authentication =
		                    new UsernamePasswordAuthenticationToken(userDetails.getUsername() ,userDetails.getPassword() , userDetails.getAuthorities());
		            System.out.println(authentication);
		            SecurityContextHolder.getContext().setAuthentication(authentication);
		            System.out.println(authentication);
		                
		            

		        }
			}
			
		}
		else {
			System.out.println("Pass Suitable Header");
		}
		filterChain.doFilter(request,response);
		
	}

}
