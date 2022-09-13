/**
 * 
 */
package com.pos.product.controller;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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
import com.pos.product.service.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	
	@InjectMocks
    ProductController productController;
    @Mock
    ProductService productService;
    @Test
	public void saveProduct() {
    	Product prod = new Product();
		
		prod.setProductID((long) 100);
		prod.setPrice(1000.00);
		prod.setProductName("dummy");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.CREATED);
		
    	Mockito.when(productService.saveProduct(prod)).thenReturn(prod);
    	productController.saveProduct(prod);
    }
    @Test
	public void fetchProductList() {
		Product prod = new Product();
		
		prod.setProductID((long) 100);
		prod.setPrice(1000.00);
		prod.setProductName("dummy");
		List<Product> prodList = new ArrayList<>();
		prodList.add(prod);
		assertNotEquals(Mockito.when(productService.fetchProductList()).thenReturn(prodList),productController.fetchProductList());
	}
}
