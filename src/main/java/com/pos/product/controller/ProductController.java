/**
 * 
 */
package com.pos.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		log.info("Payload - "+product);
		productService.saveProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/productList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> fetchProductList(){
		log.info("Product List");
		return productService.fetchProductList();
	}

}
