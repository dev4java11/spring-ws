package com.spring.ws.ssl.client.demo1;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.ws.ssl.client.demo1.client.TicketAgentClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringWsSslClientDemo1ApplicationTests {
	
	@Autowired
	private TicketAgentClient client;

	@Test
	public void contextLoads() {
		List<BigInteger> list = client.listFlights();
		for(BigInteger item : list){
			System.out.println(item);
		}
	}

}
