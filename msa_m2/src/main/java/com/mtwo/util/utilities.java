package com.mtwo.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mtwo.bean.ProcessResponse;
import com.mtwo.feign.FeignClientm3;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class utilities {
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	FeignClientm3 feignm3;
	
	public JdbcTemplate getJDBCTemplate() {
		return new JdbcTemplate(datasource);
	}
	
	public HttpEntity<ProcessResponse> getHttpEntity(MediaType mediaType,ProcessResponse body){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ProcessResponse objEmp = new ProcessResponse(true,"sending Request to m3");
		return new HttpEntity<ProcessResponse>(objEmp, headers);
	}

	@CircuitBreaker(name="msam3",fallbackMethod = "msam3fallback")
	public ProcessResponse checkm3Availability(){
		return feignm3.fetchm3Availability().getBody();
	}
	
	public ProcessResponse msam3fallback(Throwable T){
		return new ProcessResponse(false,"notAvailable");
	}
}
