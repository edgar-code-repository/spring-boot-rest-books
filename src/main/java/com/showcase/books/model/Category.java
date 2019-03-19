package com.showcase.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	private String name;

	public Category() {
		
	}
	
	public Category(Integer id) {
		this.categoryId = id;
	}	
	
	public Category(String name) {
		this.name = name;
	}	

	public Category(Integer id, String name) {
		this.categoryId = id;
		this.name = name;
	}
	
	public String toString() {
		String retorno = "";
		
		retorno = "\n<Category>\n";
		retorno = retorno + "<categoryId>" + this.categoryId + "</categoryId>\n";
		retorno = retorno + "<name>" + this.name + "</name>\n";
		retorno = retorno + "</Category>\n";		
		
		return retorno;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer id) {
		this.categoryId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
	
}
