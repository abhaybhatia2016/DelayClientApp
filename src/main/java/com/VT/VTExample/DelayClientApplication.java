package com.VT.VTExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.Delay.DelayClient.DelayClientAPI;

@SpringBootApplication
public class DelayClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelayClientApplication.class, args);
	}
	
	@Bean
	RestClient restClient(RestClient.Builder builder) {
		return builder.build();
	}
	
	@Bean
	DelayClientAPI delayClientAPI(RestClient restClient) {
		return new DelayClientAPI(restClient);
	}
}
