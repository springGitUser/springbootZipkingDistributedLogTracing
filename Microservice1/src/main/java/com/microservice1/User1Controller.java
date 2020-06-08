package com.microservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@RestController
public class User1Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/user1")
	private String sayHello() {
		LOG.info("Inside User1-Method");
		String baseUrl = "http://localhost:8082/user2";
		String response = (String) template.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response received by method1 is " + response);
		return response;

	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
