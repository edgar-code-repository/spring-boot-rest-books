package com.showcase.books.rest.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.showcase.books.model.Category;
import com.showcase.books.services.BookService;
import com.showcase.books.services.CategoryService;

@RestController
@CrossOrigin
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		logger.info("[CategoryController][getAllCategories][INICIO]");
		
		List<Category> allCategories = categoryService.getAllCategories();
		logger.info("[CategoryController][getAllCategories][categories size: " + (allCategories==null?0:allCategories.size()) + "]");
		
		logger.info("[CategoryController][getAllCategories][FIN]");
		
		return allCategories;
	}
	
	@GetMapping("/categories/{categoryId}")
	public Category getCategory(@PathVariable Integer categoryId) {
		logger.info("[CategoryController][getCategory][INICIO]");
		logger.info("[CategoryController][getCategory][categoryId: " + categoryId + "]");
		
		Category categoryById = categoryService.getCategoryById(categoryId);
		logger.info("[CategoryController][getCategory][categoryById: " + (categoryById==null?"":categoryById.toString()) + "]");
		
		logger.info("[CategoryController][getCategory][FIN]");
		
		return categoryById;
	}
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		logger.info("[CategoryController][addCategory][INICIO]");
		
		Category addCategory = categoryService.addCategory(category);
		logger.info("[CategoryController][addCategory][addCategory: " + (addCategory==null?"":addCategory.toString()) + "]");
		
		logger.info("[CategoryController][addCategory][FIN]");
		
		return addCategory;
	}
	
	@PutMapping("/categories/{categoryId}")
	public Category updateCategory(@RequestBody Category category) {
		logger.info("[CategoryController][updateCategory][INICIO]");
		logger.info("[CategoryController][updateCategory][category: " + category.toString() + "]");
		
		Category updateCategory = categoryService.updateCategory(category);
		logger.info("[CategoryController][updateCategory][updateCategory: " + (updateCategory==null?"":updateCategory.toString()) + "]");
		
		logger.info("[CategoryController][updateCategory][FIN]");
		
		return updateCategory;
	}
	
	@DeleteMapping(value="/categories/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {
		logger.info("[CategoryController][deleteCategory][INICIO]");
		logger.info("[CategoryController][deleteCategory][categoryId: " + categoryId + "]");
		
		int countBooksByCategory = bookService.countBooksByCategory(categoryId);
		logger.info("[CategoryController][deleteCategory][countBooksByCategory: " + countBooksByCategory + "]");
		
		if (countBooksByCategory == 0) {
			categoryService.deleteCategory(categoryId);
		}
		else {
			logger.info("[CategoryController][deleteCategory][FIN] NOT OK"); 
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		logger.info("[CategoryController][deleteCategory][FIN] OK"); 
		//return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
