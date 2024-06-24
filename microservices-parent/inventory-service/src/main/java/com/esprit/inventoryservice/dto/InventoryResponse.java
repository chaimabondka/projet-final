package com.esprit.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class InventoryResponse {
	private String skuCode;
    private Boolean isInStock;
    public InventoryResponse(String skuCode, Boolean isInStock) {
		this.skuCode = skuCode;
		this.isInStock = isInStock;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Boolean getIsInStock() {
		return isInStock;
	}
	public void setIsInStock(Boolean isInStock) {
		this.isInStock = isInStock;
	}
	
}
