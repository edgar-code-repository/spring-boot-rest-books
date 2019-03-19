package com.showcase.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showcase.books.model.Category;
import com.showcase.books.repositories.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryService() {
		
	}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Integer id) {
		return categoryRepository.getOne(id);
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
	
}
