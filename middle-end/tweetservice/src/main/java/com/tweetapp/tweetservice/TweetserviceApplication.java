package com.tweetapp.tweetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

/**
 * @author Nithya T
 *
 */
@SpringBootApplication
@OpenAPIDefinition
public class TweetserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetserviceApplication.class, args);
	}

}
