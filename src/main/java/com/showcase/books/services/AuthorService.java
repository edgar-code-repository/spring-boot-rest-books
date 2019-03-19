package com.showcase.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showcase.books.model.Author;
import com.showcase.books.repositories.AuthorRepository;


@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}
	
	public Author getAuthor(Integer id) {
		return authorRepository.getOne(id);
	}
	
	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public void deleteAuthor(Integer id) {
		authorRepository.deleteById(id);
	}
	
}
