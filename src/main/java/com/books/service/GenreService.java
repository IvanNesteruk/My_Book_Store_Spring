package com.books.service;

import java.util.List;

import com.books.entity.Genre;
import com.books.entity.User;

public interface GenreService {
	Genre save(Genre genre) throws Exception;
	List<Genre> findAll();
	Genre findOne(int id);
	void delete(int id);
	Genre update(Genre genre);
}
