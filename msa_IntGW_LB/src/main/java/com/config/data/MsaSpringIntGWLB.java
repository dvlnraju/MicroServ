package com.config.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsaSpringIntGWLB {

	public static void main(String[] args) {
		SpringApplication.run(MsaSpringIntGWLB.class, args);
	}

}
