package com.OAuth.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.OAuth")
@EnableEurekaClient
@EntityScan(basePackages={"com.OAuth.bean"}) 
@EnableJpaRepositories(basePackages={"com.OAuth.persistance"}) 
public class MsaOAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaOAuthApplication.class, args);
	}

}
