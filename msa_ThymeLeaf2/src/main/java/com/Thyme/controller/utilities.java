package com.Thyme.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class utilities {
		
	//@Autowired JdbcTemplate jdbc;
		
	//@Bean
	public HttpEntity<ProcessResponse> getHttpEntity(MediaType mediaType,ProcessResponse obj){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ProcessResponse objEmp = new ProcessResponse(true,"sending Request to m3");
		return new HttpEntity<ProcessResponse>(objEmp, headers);
	}

	public HttpEntity<Object> postHttpEntity(MediaType mediaType,Object obj){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//ProcessResponse objEmp = new ProcessResponse(true,"sending Request to m3");
		return new HttpEntity<Object>(obj, headers);
	}
			
}
