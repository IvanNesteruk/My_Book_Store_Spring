package com.books.dao;

import com.books.entity.Book;
import com.books.entity.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MagazineDao extends JpaRepository<Magazine, Integer> {




}
