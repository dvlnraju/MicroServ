package com.mtwo.uri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker 
//@EnableHystrix 
@EnableFeignClients(basePackages = "com.mtwo.feign")
@ComponentScan(basePackages = "com.mtwo")
@EntityScan(basePackages={"com.mtwo.entity"}) 
@EnableJpaRepositories(basePackages={"com.mtwo.persistance"}) 
public class MsaM2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsaM2Application.class, args);
	}

}
