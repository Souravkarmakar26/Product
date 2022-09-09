package com.pos.product.service;

import java.util.List;

import com.pos.product.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public List<Product> fetchProductList();
}
