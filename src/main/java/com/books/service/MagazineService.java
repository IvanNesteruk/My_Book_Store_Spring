package com.books.service;

import com.books.entity.Book;
import com.books.entity.Genre;
import com.books.entity.Magazine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface MagazineService {

    void save(Magazine magazine);
    List<Magazine> findAll();
    Magazine findOne(int id);
    void delete(int id);
    void update(String info);

}
