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

import com.showcase.books.model.Author;
import com.showcase.books.services.AuthorService;
import com.showcase.books.services.BookService;


@RestController
@CrossOrigin
public class AuthorController {

	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	private AuthorService authorService; 
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		logger.info("[AuthorController][getAllAuthors][INICIO]");
		
		List<Author> allAuthors = authorService.getAllAuthors();
		
		logger.info("[AuthorController][getAllAuthors][FIN] allAuthors size: " + (allAuthors==null?0:allAuthors.size()));
		
		return allAuthors;
	}
	
	@GetMapping("/authors/{authorId}")
	public Author getAuthor(@PathVariable Integer authorId) {
		logger.info("[AuthorController][getAuthor][INICIO]");
		
		Author author = authorService.getAuthor(authorId);
		
		logger.info("[AuthorController][getAuthor][FIN] author: " + author==null?"":author.toString());
		
		return author;
	}
	
	@PostMapping("/authors")
	public Author addAuthor(@RequestBody Author author) {
		logger.info("[AuthorController][addAuthor][INICIO]");
		
		Author addAuthor = authorService.addAuthor(author);
		
		logger.info("[AuthorController][addAuthor][FIN] addAuthor: " + addAuthor==null?"":addAuthor.toString());
		
		return addAuthor;
	}
	
	@PutMapping("/authors/{authorId}")
	public Author updateAuthor(@RequestBody Author author) {
		logger.info("[AuthorController][updateAuthor][INICIO] author id: " + author.getAuthorId());
		
		Author updateAuthor = authorService.updateAuthor(author);
		
		logger.info("[AuthorController][updateAuthor][FIN] updateAuthor: " + updateAuthor==null?"":updateAuthor.toString());
		
		return updateAuthor;
	}
	
	@DeleteMapping("/authors/{authorId}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Integer authorId) {
		logger.info("[AuthorController][deleteAuthor][INICIO] authorId: " + authorId);
		
		int countBooksByAuthor = bookService.countBooksByAuthor(authorId);
		logger.info("[AuthorController][deleteAuthor][countBooksByAuthor: " + countBooksByAuthor + "]");
		
		if (countBooksByAuthor == 0) {
			authorService.deleteAuthor(authorId);
		}
		else {
			logger.info("[AuthorController][deleteAuthor][FIN] NOT OK"); 
			return new ResponseEntity<>(HttpStatus.CONFLICT);			
		}
		
		logger.info("[AuthorController][deleteAuthor][FIN] OK");
		return new ResponseEntity<>(HttpStatus.OK);
	}		
	
	
}
