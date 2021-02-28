package com.mone.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mone.bean.ProcessResponse;
import com.mone.feign.FeignClientm2;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class utilities {
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private FeignClientm2 feignm2;
	
	public JdbcTemplate getJDBCTemplate() {
		return new JdbcTemplate(datasource);
	}
	
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
	
	
	@CircuitBreaker(name="msam2",fallbackMethod = "msam2fallback")
	public ProcessResponse checkm2Availability(){
		return feignm2.fetchm2Availability().getBody();
	}
	
	public ProcessResponse msam2fallback(Throwable T){
		return new ProcessResponse(false,"notAvailable");
	}
		
}
