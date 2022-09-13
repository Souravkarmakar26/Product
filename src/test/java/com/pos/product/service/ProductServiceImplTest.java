package com.pos.product.service;

import static org.junit.Assert.assertEquals;
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
import org.springframework.stereotype.Service;

import com.pos.product.entity.Product;
import com.pos.product.repository.ProductRepository;
import com.pos.product.service.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@InjectMocks
    ProductServiceImpl productServiceImpl;
	@Mock
	ProductRepository pr;
	@Test
	public void saveProduct() {
		Product prod = new Product();
		
		prod.setProductID((long) 100);
		prod.setPrice(1000.00);
		prod.setProductName("dummy");
		assertNotEquals(Mockito.when(productServiceImpl.saveProduct(prod)).thenReturn(prod),productServiceImpl.saveProduct(prod));
	}
	@Test
	public void fetchProductList() {
		Product prod = new Product();
		
		prod.setProductID((long) 100);
		prod.setPrice(1000.00);
		prod.setProductName("dummy");
		List<Product> prodList = new ArrayList<>();
		prodList.add(prod);
		assertNotEquals(Mockito.when(productServiceImpl.fetchProductList()).thenReturn(prodList),productServiceImpl.fetchProductList());
	}

}
