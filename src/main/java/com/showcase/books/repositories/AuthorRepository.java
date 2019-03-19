package com.showcase.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showcase.books.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	
}
