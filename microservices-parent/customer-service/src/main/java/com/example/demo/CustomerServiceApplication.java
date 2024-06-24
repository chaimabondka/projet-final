package com.example.demo;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CustomerRepository customarRepo) {

		return args -> {

			Customer c1 = new Customer("customer1", "customer1@gmail.com", new BigDecimal("350.22"));
			Customer c2 = new Customer("customer1", "customer1@gmail.com", new BigDecimal("360.22"));
			customarRepo.save(c1);
			customarRepo.save(c2);
		};
	}
}
