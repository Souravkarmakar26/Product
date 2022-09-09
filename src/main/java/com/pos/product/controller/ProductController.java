/**
 * 
 */
package com.pos.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.product.entity.Product;
import com.pos.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		System.out.println("---------"+product);
		productService.saveProduct(product);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/productList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> fetchProductList(){
		return productService.fetchProductList();
	}

}
