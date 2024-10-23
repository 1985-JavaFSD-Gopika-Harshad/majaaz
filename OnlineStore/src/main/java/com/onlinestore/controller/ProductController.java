package com.onlinestore.controller;
import com.onlinestore.model.*;
import com.onlinestore.service.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/products")
public class ProductController {
private final ProductService productService;
@Autowired
	public ProductController(ProductService productService) {
		// TODO Auto-generated constructor stub
this.productService=productService;	
}
@GetMapping
public ResponseEntity<List<Product>> getAllProducts(){
	return ResponseEntity.ok(productService.getAllProducts());
}
@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Long id)
{
	return ResponseEntity.ok(productService.getProductByd(id));
}

@PostMapping
public ResponseEntity<Product> createProduct(@RequestBody Product product)
{
	return ResponseEntity.ok(productService.createProduct(product));
}

@PutMapping
public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product)
{
	return ResponseEntity.ok(productService.updateProduct(id, product));
}

@DeleteMapping
public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
{
	productService.deleteProductById(id);
	 return ResponseEntity.noContent().build();
}


}
