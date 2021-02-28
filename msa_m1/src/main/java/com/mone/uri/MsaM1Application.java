package com.mone.uri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
/*import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
*/import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
/* @EnableCircuitBreaker */
/* @EnableHystrix */
@EnableFeignClients(basePackages = "com.mone.feign")
@ComponentScan(basePackages = "com.mone")
@EntityScan(basePackages={"com.mone.entity"}) 
@EnableJpaRepositories(basePackages={"com.mone.persistance"}) 
public class MsaM1Application {

	public static void main(String[] args) {
		SpringApplication.run(MsaM1Application.class, args);
	}

}
