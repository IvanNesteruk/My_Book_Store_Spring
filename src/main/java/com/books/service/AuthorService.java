package com.books.service;

import java.util.List;

import com.books.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
	Author save(Author author) throws Exception;
	List<Author> findAll();
	Author findOne(int id);
	void delete(int id);
	Author update(Author author);
	Page<Author> findAllPages(Pageable pageable);
}
