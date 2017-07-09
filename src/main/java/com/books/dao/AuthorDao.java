package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.books.entity.Author;

public interface AuthorDao extends JpaRepository<Author, Integer> {
	Author findByNameAndSurname(String name, String surname);

	@Query("select a from Author a left join fetch a.books where a.id=:id")
	Author findAuthorWithBooks(@Param("id") int id);

    Author findByName(String name);
}
