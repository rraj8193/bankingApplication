package com.project.banking.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.project.banking.customer.dao.AuthInfoServiceImpl;
import com.project.banking.customer.entities.AuthInfo;
import com.project.banking.customer.entities.JwtRequest;
import com.project.banking.customer.entities.JwtResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

	// public static final long JWT_TOKEN_VALIDITY = 60;
	private String secret = "ThisIsASecretKeyWhichNeedsToHaveSizeGreaterThan256";
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	AuthInfoServiceImpl authInfoService;
	
	
	public String getUsername(String token) {
		return getClaim(token, Claims::getSubject);
	}
	
	public <T> T getClaim(String token, Function<Claims, T> claimResolver) {
		Claims claim = getAllClaims(token);
		return claimResolver.apply(claim);
	}

	public Claims getAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public JwtResponse authenticate(JwtRequest jwtRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword())
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		System.out.println("authenticate method getting executed");
		AuthInfo authInfo = authInfoService.getAuthenticationInfoByUsername(jwtRequest.getUsername());
		List<String> rolesNames = new ArrayList<>();
        rolesNames.add("ROLE_"+authInfo.getRole());
        String token = generateToken(authInfo.getUsername(),rolesNames);
        
        JwtResponse jwtResponse = new JwtResponse(jwtRequest,token);
        return jwtResponse;		
	}
	
	public String generateToken(String username,List<String> roles) {
		return Jwts.builder().setSubject(username).claim("role",roles).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
		
	}

}
