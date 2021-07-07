package com.message.pkg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.EnableJms;

import com.message.sender.MessageSender;

@SpringBootTest
class MsaMessageQueueApplicationTests {

	@Autowired
	MessageSender msgSender;
	
	@Test
	public void testSendAndReceive() {
		msgSender.send("Hello");
	}
	
	

}
