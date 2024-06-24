package com.esprit.microservice.orderservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/order")
public class OrderRestAPI {
	private String title = "Order microservice is up";
	
	@Autowired
	private OrderService orderService;
	@RequestMapping("/acceuil")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getAllOrders")
	public List<Order> getAllOrders(){
		return orderService.getOrder();
	}
	
}
