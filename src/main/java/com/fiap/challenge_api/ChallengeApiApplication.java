package com.fiap.challenge_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChallengeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApiApplication.class, args);
	}

}
