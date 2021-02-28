package com.config.data;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.EnableConfigServer;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigServer
public class MsaConfigServerApplication {

	//@Autowired
	//private static Environment env;
	
	
	public static void main(String[] args) {
		//env.
		SpringApplication.run(MsaConfigServerApplication.class, args);
	}

}
