package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entities.Product;
import com.product.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Override
	public Integer addProduct(Product product) {
		// TODO Auto-generated method stub
		Product addProduct = productRepository.save(product);
		return addProduct.getId();
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

}
