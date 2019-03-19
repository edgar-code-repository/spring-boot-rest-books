package com.showcase.books.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	private String name;
	private String isbn;
	private String imageName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.MERGE })
    @JoinTable(name = "book_authors", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = { @JoinColumn(name = "authorId") })	
	private List<Author> authors = new ArrayList<>();	
	
	@Column(length=2500)
	private String description;	
	
	public Book() {
		
	}
	
	public Book(String name, String isbn, String imageName, String description) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.imageName = imageName;
		this.description = description;
	}	
	
	public Book(Integer id, String name, String isbn, String imageName, String description) {
		super();
		this.bookId = id;
		this.name = name;
		this.isbn = isbn;
		this.imageName = imageName;
		this.description = description;
	}
	
	public String toString() {
		String retorno;
		
		retorno = "\n<Book>\n";
		retorno = retorno + "<bookId>" + this.bookId + "</bookId>\n";
		retorno = retorno + "<name>" + this.name + "</name>\n";
		retorno = retorno + "<isbn>" + this.isbn + "</isbn>\n";
		retorno = retorno + "<imageName>" + this.imageName + "</imageName>\n";
		retorno = retorno + "<description>" + this.description + "</description>\n";
		
		if (category != null) {
			retorno = retorno + "<Category>\n";
			retorno = retorno + category.toString();
			retorno = retorno + "</Category>\n";				
		}
		
		if (authors != null && authors.size() > 0) {
			retorno = retorno + "<authors>\n";
			
			for (Author author: authors) {
				retorno = retorno + "<Author>\n";
				retorno = retorno + author.toString();
				retorno = retorno + "</Author>\n";				
			}
			
			retorno = retorno + "<authors>\n";
		}
		
		retorno = retorno + "</Book>\n";
		
		return retorno;
	}	
	
	public Integer getBookId() {
		return bookId;
	}
	
	public void setBookId(Integer id) {
		this.bookId = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
