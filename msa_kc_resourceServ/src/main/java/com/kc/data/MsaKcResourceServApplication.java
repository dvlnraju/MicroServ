package com.kc.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.kc")
@EnableEurekaClient
@EntityScan(basePackages={"com.kc.bean"}) 
@EnableJpaRepositories(basePackages={"com.kc.persistance"}) 
public class MsaKcResourceServApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaKcResourceServApplication.class, args);
	}

}
