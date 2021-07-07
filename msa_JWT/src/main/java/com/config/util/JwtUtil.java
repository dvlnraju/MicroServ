package com.config.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtUtil {

	private String KEY = "";
	//private String RKEY = "";
	
	{
		LocalDateTime dateTime = LocalDateTime.now();
		Month month = dateTime.getMonth();
		int day = dateTime.getDayOfMonth();
		KEY = (String.valueOf(day))+month.name().toString()+("#V@rK*y");
	}
	
	/*
	 * { RKEY = "#V@rK*y"; }
	 */
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*15*1))
				.signWith(SignatureAlgorithm.HS256, KEY).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	private String createRefToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*15*8))
				.signWith(SignatureAlgorithm.RS256, KEY).compact();
	}
	
	public String generateRefToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		return createRefToken(claims,userDetails.getUsername());
	}
	
	public Boolean validateRefToken(String reftoken, UserDetails userDetails) {
		final String username = extractUsername(reftoken);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(reftoken));
	}
	
}
