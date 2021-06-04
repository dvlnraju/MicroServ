package com.Thyme.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Thyme"})
public class MsaThymeLeafApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaThymeLeafApplication.class, args);
	}

}
