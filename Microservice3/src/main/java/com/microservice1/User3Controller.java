package com.microservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@RestController
public class User3Controller {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/user3")
	private String sayHello() {
		LOG.info("Inside User3-Method");
		
		return "The response received by method3 is Final...";

	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
