package com.esprit.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory")
public class Inventory {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String skuCode;
    private Integer quantity;
    
    public Inventory(String skuCode, Integer quantity) {
	this.skuCode = skuCode;
		this.quantity = quantity;
	}
    public Inventory() { 
    	}
    public String getSkuCode() {
  		return skuCode;
  	}
  	public void setSkuCode(String skuCode) {
  		this.skuCode = skuCode;
  	}
  	public Integer getQuantity() {
  		return quantity;
  	}
  	public void setQuantity(Integer quantity) {
  		this.quantity = quantity;
  	}

}
