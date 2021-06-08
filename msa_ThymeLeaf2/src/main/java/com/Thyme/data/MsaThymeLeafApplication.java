package com.Thyme.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Thyme"})
@EnableEurekaClient
public class MsaThymeLeafApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaThymeLeafApplication.class, args);
	}

}
