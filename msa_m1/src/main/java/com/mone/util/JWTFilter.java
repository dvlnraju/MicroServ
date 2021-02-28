package com.mone.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mone.feign.FeignClientm2;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class JWTFilter extends OncePerRequestFilter{

	@Autowired 
	private FeignClientm2 feignm2;
	 
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(feignm2.checkValidity(request.getHeader("Authorization")).getBody().equals("Success")) {
			filterChain.doFilter(request, response);
		}else{
			throw new ServletException("JWT didnot match");
		}
	}
		
}
