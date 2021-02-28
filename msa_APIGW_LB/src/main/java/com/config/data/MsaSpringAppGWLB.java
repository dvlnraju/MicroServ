package com.config.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsaSpringAppGWLB {

	public static void main(String[] args) {
		SpringApplication.run(MsaSpringAppGWLB.class, args);
	}

}
