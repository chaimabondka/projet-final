package com.esprit.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.productservice.dto.ProductRequest;
import com.esprit.productservice.dto.ProductResponse;
import com.esprit.productservice.model.Product;
import com.esprit.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    
	@Autowired
    ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
	    Product product = new Product();
	    product.setName(productRequest.getName());
	    product.setDescription(productRequest.getDescription());
	    product.setPrice(productRequest.getPrice());
	    productRepository.save(product);
	}

	public List<ProductResponse> getAllProducts() {
	    List<Product> products = productRepository.findAll();
	    List<ProductResponse> productResponses = new ArrayList<>();
	    for (Product product : products) {
	        ProductResponse productResponse = new ProductResponse();
	        productResponse.setId(product.getId());
	        productResponse.setName(product.getName());
	        productResponse.setDescription(product.getDescription());
	        productResponse.setPrice(product.getPrice());
	        productResponses.add(productResponse);
	    }
	    return productResponses;
	}
}
