package com.yectra.roos.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

@SpringBootApplication
@EnableCosmosRepositories
public class RoosOrderApplication {

	public static void main(String[] args) {
	       SpringApplication.run(RoosOrderApplication.class, args);
	}

}
