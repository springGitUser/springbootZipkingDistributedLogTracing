package com.zikin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class DemoZipKinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoZipKinServerApplication.class, args);
	}

}
