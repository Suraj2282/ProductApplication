package com.cts.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cts.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static Map<String, Product> productRepository = new HashMap<>();
	
	static{
		Product mobile = new Product();
		mobile.setId("1");
		mobile.setName("Samsung s22");
		mobile.setPrice(38000);
		productRepository.put(mobile.getId(), mobile);
		
		Product laptop = new Product();
		laptop.setId("2");
		laptop.setName("HP Pavilion");
		laptop.setPrice(56000);
		productRepository.put(laptop.getId(), laptop);
		
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.put(product.getId(), product);
		
	}

	@Override
	public void updateProduct(String id, Product product) {
		// TODO Auto-generated method stub
		productRepository.remove(product);
		product.setId(id);
		productRepository.put(id, product);
		
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		productRepository.remove(id);
		
	}

	@Override
	public Collection<Product> getProducts() {
		// TODO Auto-generated method stub
		
		return productRepository.values();
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return productRepository.get(id);
	}

}
