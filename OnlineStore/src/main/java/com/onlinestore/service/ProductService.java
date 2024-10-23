package com.onlinestore.service;
import com.onlinestore.model.*;
import com.onlinestore.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ProductService {
 private final ProductRepository productRepository;
 @Autowired
 public ProductService(ProductRepository productRepository)
 {
	 this.productRepository=productRepository;
 }
 
 public List<Product> getAllProducts(){
	 return productRepository.findAll();
 }
 
 
 public Product getProductByd(Long id)
 {
	 return productRepository.findById(id).orElseThrow();
 }
 
 public Product createProduct(Product product)
 {
	 return productRepository.save(product);
 }
 
 public void deleteProductById(Long id)
 {
	  productRepository.deleteById(id);
 }
 
 public Product updateProduct(Long id,Product product)
 {
	 Product p1=productRepository.findById(id).orElseThrow();
	 p1.setName(product.getName());
	 p1.setPrice(product.getPrice());
	 p1.setCategory(product.getCategory());
	 p1.setQuantity(product.getQuantity());
	 return productRepository.save(p1);
 }
 
 
}
