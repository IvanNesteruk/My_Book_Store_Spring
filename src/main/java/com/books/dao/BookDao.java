package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookDao extends JpaRepository<Book, Integer> {

    Book findByTitleOfBook(String name);
    Book findByPriceOfBook(int price);

    @Query("select distinct b from Book b left join fetch b.users where b.id=:id")
    Book booksWithUsers(@Param("id") int id);

	// public byte[] addImageToBook(String path) throws IOException;
}
