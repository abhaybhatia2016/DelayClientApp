package com.VT.VTExample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.Delay.DelayClient.DelayClientAPI;

@RestController
public class DelayController {

	private final DelayClientAPI delayClientAPI;

	DelayController(DelayClientAPI delayClientAPI) {
		this.delayClientAPI = delayClientAPI;
	}

	@GetMapping("/{seconds}")
	public int getDelayedData(@PathVariable("seconds") int seconds) {
		System.out.println("Received request to delay for "+ seconds+" - Client Application - " + Thread.currentThread());
		int result = delayClientAPI.delay(seconds);

//		var result = restClient
//				.get()
//				.uri("http://localhost:8081/delay/"+seconds)
//				.retrieve()
//				.body(Integer.class);
		return result;
	}
}
