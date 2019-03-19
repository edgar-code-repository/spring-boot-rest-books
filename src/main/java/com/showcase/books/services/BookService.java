package com.showcase.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showcase.books.model.Book;
import com.showcase.books.repositories.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBookList() {
		return bookRepository.findAll();
	}
	
	public Book getBookById(Integer id) {
		return bookRepository.getOne(id);
	}
	
	public Book addBook(Book book) {
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}
	
	public Book updateBook(Book book) {
		Book updatedBook = bookRepository.save(book);
		return updatedBook;		
	}
	
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);		
	}
	
	public int countBooksByCategory(Integer categoryId) {
		int count = 0;
		
		List<Book> findByCategory = bookRepository.findByCategoryCategoryId(categoryId);
		if (findByCategory != null && findByCategory.size() > 0) {
			count = findByCategory.size();
		}
		
		return count;
	}
	
	public int countBooksByAuthor(Integer authorId) {
		int count = 0;
		
		List<Book> findByAuthorAuthorId = bookRepository.findByAuthorsAuthorId(authorId);
		if (findByAuthorAuthorId != null && findByAuthorAuthorId.size() > 0) {
			count = findByAuthorAuthorId.size();
		}
		
		return count;
	}	
	
}
