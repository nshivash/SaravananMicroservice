package com.Security.SecurityDemo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	private final static String SECRET_KEY_STRING ="tdepbMXGAqKlYNdQ4GrUQxYv93s2U6CH";
	private final SecretKey secretkey=Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());
	
	public String generateToken(UserDetails userdetails) {
		return Jwts.builder()
		.subject(userdetails.getUsername())
		.issuedAt(new Date())
		.expiration(new Date(System.currentTimeMillis() + 1000*60*60))
		.signWith(secretkey,Jwts.SIG.HS256)
		.compact()
		;
	}
	public boolean validateToken(String token,UserDetails userdetails) {
		return extractUsername(token).equals(userdetails.getUsername());
	}
	public String extractUsername(String token) {
		return Jwts.parser()
			.verifyWith(secretkey)
			.build()
			.parseSignedClaims(token)
			.getPayload()
			.getSubject();
	}
}
