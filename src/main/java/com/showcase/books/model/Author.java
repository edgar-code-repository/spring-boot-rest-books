package com.showcase.books.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbl_author")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;
	
	private String firstName;
	private String lastName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "authors")
	@JsonIgnore
	private List<Book> books = new ArrayList<>(); 
	
	public Author() {
		
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		String retorno = "";
		
		retorno = "\n<Author>\n";
		retorno = retorno + "<authorId>" + this.authorId + "</authorId>\n";
		retorno = retorno + "<firstName>" + this.firstName + "</firstName>\n";
		retorno = retorno + "<lastName>" + this.lastName + "</lastName>\n";
		retorno = retorno + "</Author>\n";		
		
		return retorno;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Integer id) {
		this.authorId = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
