package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Product;
import com.cts.service.ProductService;
import com.cts.service.ProductServiceImpl;

@RestController

public class ProductController {
	
	 @Autowired
	   ProductService productService;

	   @GetMapping(value = "/products")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	   }
	   
	   @GetMapping(value = "/products/{id}")
	   public ResponseEntity<Object> getProductById(@PathVariable("id") String id) {
	      
	      return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	   }
	   @PutMapping(value = "/products/{id}")
	   public ResponseEntity<Object> 
	      updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
	      
	      productService.updateProduct(id, product);
	      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	   }
	   @DeleteMapping(value = "/products/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
	      productService.deleteProduct(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	   @PostMapping(value = "/products")
	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
	      productService.createProduct(product);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }

}
