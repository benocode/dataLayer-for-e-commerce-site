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
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Iterable<Product> getProductsByName(String name) {
//		return productRepository.findByName(name);
		return productRepository.findByNameJPQL(name);
	}
	
	public Iterable<Product> getProductsByCategoryName(String name) {
		return productRepository.findByCategoriesName(name);
	}
	
	public Iterable<Product> getProductsByCost(int cost) {
		return productRepository.findByCostNative(cost);
	}
	
	public Iterable<Product> getProductsWhereCostLessThan(int cost) {
		return productRepository.findByCostLessThan(cost);
	}

}
