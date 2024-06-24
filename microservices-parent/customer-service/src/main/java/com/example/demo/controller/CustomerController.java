package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;


    @GetMapping("/getAllCostomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public void updateMonthlySpending(@PathVariable Long customerId, @RequestParam BigDecimal monthlySpending) {
        customerService.updateMonthlySpending(customerId, monthlySpending);
    }

    @GetMapping("/{customerId}/discount")
    public BigDecimal calculateDiscountedAmount(@PathVariable Long customerId, @RequestParam BigDecimal amount) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            BigDecimal discountedAmount = customerService.calculateDiscountedAmount(amount);
            return discountedAmount;
        }
        return null;
        		
    }

}
