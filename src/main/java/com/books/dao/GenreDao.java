package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entity.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface GenreDao extends JpaRepository<Genre, Integer> {
    Genre findByGenreOfBook(String name);

    @Query("select g from Genre g left join fetch g.books where g.id=:id")
    Genre findGenreWithBooks(@Param("id") int id);
}
