package com.esprit.microservice.orderservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
	 @Bean
	    ApplicationRunner init(OrderRepository repository) {
	        return args -> {
	            Stream.of(12555, 1442, 1455,1546).forEach(id -> {
	                repository.save(new Order(id));
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	    }

}
