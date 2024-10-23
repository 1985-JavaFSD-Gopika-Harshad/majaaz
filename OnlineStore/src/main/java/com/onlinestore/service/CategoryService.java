package com.onlinestore.service;
import com.onlinestore.model.*;
import com.onlinestore.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.*;
import java.util.List;
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	
	public List<Category> getAllCategories()
	{
		return categoryRepository.findAll();
	}
	
	public Category findCategoryById(Long id)
	{
		return categoryRepository.findById(id).orElseThrow();
	}
	public Category createCategory(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id)
	{
		 categoryRepository.deleteById(id);
	}
	
	public Category updateCategory(Long id, Category category)
	{
		Category c1=categoryRepository.findById(id).orElseThrow();
		c1.setCategoryName(category.getCategoryName());
		
		return categoryRepository.save(c1);
	}
	

}
