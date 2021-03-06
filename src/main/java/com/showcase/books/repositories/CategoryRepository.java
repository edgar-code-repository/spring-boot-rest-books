package com.showcase.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showcase.books.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
