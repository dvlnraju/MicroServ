package com.config.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.config")
@EnableEurekaClient
@EntityScan(basePackages={"com.config.bean"}) 
@EnableJpaRepositories(basePackages={"com.config.persistance"}) 
public class MsaJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaJwtApplication.class, args);
	}

}
