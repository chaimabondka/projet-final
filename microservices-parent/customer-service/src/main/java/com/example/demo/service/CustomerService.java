package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public void updateMonthlySpending(Long customerId, BigDecimal monthlySpending) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setMonthlySpending(monthlySpending);
            customerRepository.save(customer);
        }
    }

    public BigDecimal calculateDiscountedAmount(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("300")) >= 0) {
            return amount.multiply(new BigDecimal("0.7"));
        }
        return amount;
    }
}
