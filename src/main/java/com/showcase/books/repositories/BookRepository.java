package com.showcase.books.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showcase.books.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByCategoryCategoryId(Integer categoryId);
	
	public List<Book> findByAuthorsAuthorId(Integer authorId);
	
}
