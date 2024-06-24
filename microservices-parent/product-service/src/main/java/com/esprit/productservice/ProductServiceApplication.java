package com.esprit.productservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.esprit.productservice.model.Product;
import com.esprit.productservice.repository.ProductRepository;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	 @Bean
	    ApplicationRunner init(ProductRepository repository) {
	        return args -> {
	            Stream.of("1", "2", "3","4").forEach(id -> {
	                repository.save(new Product(id));
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	    }
}
