package com.product.services;

import java.util.List;

import com.product.entities.Product;

public interface IProductService {

	Integer addProduct(Product product);
	
	public List<Product> getProducts();
}
