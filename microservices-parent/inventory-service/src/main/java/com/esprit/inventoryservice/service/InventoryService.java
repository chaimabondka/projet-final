package com.esprit.inventoryservice.service;

import com.esprit.inventoryservice.dto.InventoryResponse;
import com.esprit.inventoryservice.model.Inventory;
import com.esprit.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	@Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(skuCode);
        List<InventoryResponse> inventoryResponses = new ArrayList<>();
        for (Inventory inventory : inventoryList) {
            boolean isInStock = inventory.getQuantity() > 0;
            InventoryResponse inventoryResponse = new InventoryResponse(inventory.getSkuCode(), isInStock);
            inventoryResponses.add(inventoryResponse);
        }
        return inventoryResponses;
    }
}
