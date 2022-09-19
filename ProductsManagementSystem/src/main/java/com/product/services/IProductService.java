package com.product.services;

import java.util.List;
import java.util.Optional;

import com.product.entities.Product;

public interface IProductService {

	Integer addProduct(Product product);
	
	public List<Product> getProducts();
	
	Optional<Product> getProduct(int id);
}
