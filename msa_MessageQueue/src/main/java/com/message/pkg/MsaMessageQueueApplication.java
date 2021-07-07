package com.message.pkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MsaMessageQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaMessageQueueApplication.class, args);
	}

}
