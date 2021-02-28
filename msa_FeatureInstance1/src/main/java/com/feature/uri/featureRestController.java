package com.feature.uri;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Path("/ftre")
public class featureRestController {

	@Value(value = "${server.port}")
	private String portNo;
	
	@Value(value = "${spring.application.name}")
	private String appName;
	
	@GetMapping("/ftre/")
	public String getinfo() {
		return appName;
	}
	
	@GetMapping("/ftre/port")
	public String getPort() {
		return portNo;
	}
	
}
