package com.microservice.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthenticationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationMicroserviceApplication.class, args);
	}

}
