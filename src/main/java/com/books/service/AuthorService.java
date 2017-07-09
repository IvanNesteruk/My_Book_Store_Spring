package com.books.service;

import java.util.List;

import com.books.entity.Author;

public interface AuthorService {
	Author save(Author author) throws Exception;
	List<Author> findAll();
	Author findOne(int id);
	void delete(int id);
	Author update(Author author);
}
