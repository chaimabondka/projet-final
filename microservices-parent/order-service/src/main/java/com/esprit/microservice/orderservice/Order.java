package com.esprit.microservice.orderservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "order_table")
public class Order implements Serializable{
	
 	@Id
	@GeneratedValue
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Order() {
		super();
	}
	public Order(int id) {
		super();
		this.id = id;
	}
	
}
