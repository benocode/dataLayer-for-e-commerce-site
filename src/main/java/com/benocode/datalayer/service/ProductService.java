package com.benocode.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benocode.datalayer.model.Product;
import com.benocode.datalayer.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Optional<Product> getProductById(Integer id) {
		return productRepository.findById(id);
	}
}
