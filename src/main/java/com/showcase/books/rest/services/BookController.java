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

import com.showcase.books.model.Book;
import com.showcase.books.services.BookService;


@RestController
@CrossOrigin
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		logger.info("[BookController][getAllBooks][INICIO]");
		
		List<Book> bookList = bookService.getBookList();
		
		logger.info("[BookController][getAllBooks][FIN] bookList size: " + (bookList==null?0:bookList.size()));
		
		return bookList;
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable Integer bookId) {
		logger.info("[BookController][getBook][INICIO]");
		
		Book bookById = bookService.getBookById(bookId);
		
		logger.info("[BookController][getBook][FIN] bookById: " + bookById==null?"":bookById.toString());
		
		return bookById;
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		logger.info("[BookController][addBook][INICIO]");
		logger.info("[BookController][addBook][book: " + book==null?"":book + "]");
		
		Book addBook = bookService.addBook(book);
		
		logger.info("[BookController][addBook][FIN] addBook: " + addBook==null?"":addBook.toString());
		
		return addBook;
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book) {
		logger.info("[BookController][updateBook][INICIO] book id: " + book.getBookId());
		logger.info("[BookController][updateBook][book: " + (book==null?"":book.toString()) + "]");
		
		Book updateBook = bookService.updateBook(book);
		
		logger.info("[BookController][updateBook][FIN] updateBook: " + updateBook==null?"":updateBook.toString());
		
		return updateBook;
	}
	
	@DeleteMapping("/books/{bookId}")
	@CrossOrigin
	public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
		logger.info("[BookController][deleteBook][INICIO] bookId: " + bookId);
		
		bookService.deleteBook(bookId);
		
		logger.info("[BookController][deleteBook][FIN] bookId: " + bookId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}
