package com.pos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.product.entity.Product;
import com.pos.product.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository pr;

	@Override
	public Product saveProduct(Product product) {
		return pr.save(product);		
	}

	@Override
	public List<Product> fetchProductList() {
		return (List<Product>) pr.findAll();
	}

}
