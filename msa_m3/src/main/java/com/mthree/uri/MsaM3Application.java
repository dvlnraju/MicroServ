package com.mthree.uri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = "com.mthree")
@EntityScan(basePackages={"com.mthree.entity"}) 
@EnableJpaRepositories(basePackages={"com.mthree.persistance"}) 
public class MsaM3Application {

	public static void main(String[] args) {
		SpringApplication.run(MsaM3Application.class, args);
	}

}
