package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getMonthlySpending() {
		return monthlySpending;
	}

	public void setMonthlySpending(BigDecimal monthlySpending) {
		this.monthlySpending = monthlySpending;
	}

	private String name;
    private String email;
    private BigDecimal monthlySpending;

    public Customer() {
    }

    public Customer(String name, String email, BigDecimal monthlySpending) {
        this.name = name;
        this.email = email;
        this.monthlySpending = monthlySpending;
    }
}