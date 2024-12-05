package com.cts.service;

import java.util.Collection;

import com.cts.model.Product;

public interface ProductService {

	void createProduct(Product product);

	void updateProduct(String id, Product product);

	void deleteProduct(String id);

	Collection<Product> getProducts();

	Product getProductById(String id);
}
